import java.io.DataOutputStream;import java.io.*;import java.io.FileOutputStream;import java.io.IOException; public class MainS2 { public static void main(String[] args) throws IOException { for (int i = 0; i < 100; i++) { int rndNum = 0 + (int) (Math.random() * 1000000); System.out.println(rndNum); } }} 