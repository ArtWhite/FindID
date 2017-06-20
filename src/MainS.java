import java.io.DataOutputStream;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by g15oit18 on 28.04.2017.
 */
public class MainS {

    /**
     * Метод записывает рандомные числа в файл intdata.dat
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 100; i++) {
            int rndNum = 0 + (int) (Math.random() * 1000000);       // Однострочтный коммент
            System.out.println(rndNum);
        }

    }


}
/**
 * Метод записывает рандомные числа в файл intdata.dat
 *
 * @param args
 * @throws IOException
 */