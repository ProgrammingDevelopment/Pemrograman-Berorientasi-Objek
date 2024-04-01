import java.io.*;

public class CustomBufferedReader {
    public static void main(String[] args) throws Exception {
        InputStreamReader keyReader = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(keyReader);

        String kata1, kata2;

        System.out.println("Masukan Kata Pertama: ");
        kata1 = input.readLine();
        System.out.println("Masukan Kata Kedua: ");
        kata2 = input.readLine();
        System.out.println("\nHasil Input String: " + kata1 + " " + kata2);

        // Close the BufferedReader to release system resources
        input.close();
    }
}
