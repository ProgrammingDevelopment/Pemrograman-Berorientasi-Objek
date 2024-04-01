import java.util.Scanner;

public class AppScanner {
    private String nama;
    private double nilai1, nilai2, nilai3;

    public void inputScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama Anda: ");
        nama = scanner.nextLine();

        System.out.print("Masukkan nilai pertama: ");
        nilai1 = scanner.nextDouble();

        System.out.print("Masukkan nilai kedua: ");
        nilai2 = scanner.nextDouble();

        System.out.print("Masukkan nilai ketiga: ");
        nilai3 = scanner.nextDouble();
    }

    public String getnama() {
        return nama;
    }

    public double rata() {
        return (nilai1 + nilai2 + nilai3) / 3.0;
    }
}
