import java.util.Scanner;

public class SalonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        double totalPayment = 0;

        do {
            System.out.println("Welcome to Our Salon Switch-case");
            System.out.println("Pilihan Menu:");
            System.out.println("1. Haircut - 20K");
            System.out.println("2. Manicure - 15K");
            System.out.println("3. Pedicure - 20K");
            System.out.println("4. Facial - 25K");
            System.out.println("5. Exit");

            System.out.print("Masukan Pilihan Kamu: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    totalPayment += 20;
                    break;
                case '2':
                    totalPayment += 15;
                    break;
                case '3':
                    totalPayment += 20;
                    break;
                case '4':
                    totalPayment += 25;
                    break;
                case '5':
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != '5');

        // Apply discount with payment
        double discount = totalPayment * 0.30;
        double discountedTotal = totalPayment - discount;

        System.out.println("Total payment before discount: K" + totalPayment);
        System.out.println("15% discount applied: -K" + discount);
        System.out.println("Total payment after discount: K" + discountedTotal);

        System.out.println("Terimakasih telah Mengunjungi Salon Switch-case!");
        scanner.close();
    }
}
