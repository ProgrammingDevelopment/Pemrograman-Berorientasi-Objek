import java.util.Scanner;

public class KalkulatorApplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Kalkulator Sederhana ===");
        System.out.println("Pilih operasi:");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (*)");
        System.out.println("4. Pembagian (/)");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt();

        System.out.print("Masukkan angka pertama: ");
        double num1 = scanner.nextDouble();

        System.out.print("Masukkan angka kedua: ");
        double num2 = scanner.nextDouble();

        double result;
        switch (choice) {
            case 1:
                result = num1 + num2;
                System.out.println("Hasil penjumlahan: " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("Hasil pengurangan: " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("Hasil perkalian: " + result);
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Pembagian oleh nol tidak diizinkan.");
                } else {
                    result = num1 / num2;
                    System.out.println("Hasil pembagian: " + result);
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }
}