import java.io.*;
import java.util.regex.*;

/**
 * Created by Artem Umnov on 31/05/2017.
 */
public class FindID {
    public static void main(String[] args) throws IOException {
        String s = null;
        String oneLine;
        Pattern linePattern = Pattern.compile(".*");
        Matcher lineM = linePattern.matcher("");
        Pattern pattern = Pattern.compile("\\b[A-z,_]+[A-z,0-9,_]*\\b");
        Matcher matcher = pattern.matcher("");

        oneLine = codeToOneLine(s, linePattern, lineM);
        deleteComments(linePattern, lineM, oneLine);

        /**
         * Запись идентефикаторов в Ids.txt
          */
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("MainS2.java"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Ids.txt"))) {
            while ((s = bufferedReader.readLine()) != null) {
                matcher.reset(s);
                while (matcher.find()) {
                    bufferedWriter.write(matcher.group()+"\n");
                }
            }
        }
    }

    /**
     * Метод убирает из строки многострочные комментарии и лишние пробелы и результат записывет в файл MainS2.java
     *
     * @param linePattern
     * @param lineM
     * @param oneLined - код в одну строку
     * @throws IOException
     */
    private static void deleteComments(Pattern linePattern, Matcher lineM, String oneLined) throws IOException {
        BufferedWriter oneLine = new BufferedWriter(new FileWriter("MainS2.java"));
        lineM.reset(oneLined);
        while (lineM.find()) {
            oneLined = lineM.group();
            oneLined = oneLined.replaceAll("\\/\\*[^\\/].+?[\\/]", " ");
            oneLined = oneLined.replaceAll("\\s+", " ");
            oneLine.write(oneLined);
        }
        oneLine.close();
    }

    /**
     * Метод считывает код из файла MainS.java и записывает в строку string
     *
     * @param s - полученная строка из файла
     * @param linePattern
     * @param lineM
     * @return
     * @throws IOException
     */
    private static String codeToOneLine(String s, Pattern linePattern, Matcher lineM) throws IOException {
        String string = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/MainS.java"))) {
            while ((s = bufferedReader.readLine()) != null) {
                lineM.reset(s);
                while (lineM.find()) {
                    s = lineM.group();
                    s = s.replaceAll("MainS", "MainS2");
                    s = s.replaceAll("\\/\\/.+", " ");
                    s = s.replaceAll("\\t", " ");
                    //oneLine.write(s);
                    string += s;
                }
            }
        }
        return string;
    }
}