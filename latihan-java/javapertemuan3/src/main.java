import java.util.Scanner;

public class main {
    final static int MAX = 100;
    static int[] nomer = new int[MAX];
    static int tail = -1;
    static int head = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menu = {"Menu1", "Menu2", "Menu3"}; // Example menu items
        double[] harga_promo = {10.0, 20.0, 30.0}; // Example prices
        int[] jumlah = new int[menu.length];
        double[] subtotal = new double[menu.length];
        double total_bayar = 0;
        int dibeli = 0;

        while (true) {
            System.out.println("\t\t\t\t\t+----------------------------------------------------------------------+");
            System.out.println("\t\t\t\t\t|                           KopiKirin TB 1                             |");
            System.out.println("\t\t\t\t\t+----------------------------------------------------------------------+\n");

            System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------");
            System.out.println("\t\t\t\t\t\t|                    Pembayaran Non-Tunai (Cashless)                  |");
            System.out.println("\t\t\t\t\t\t|                                                                     |");
            System.out.println("\t\t\t\t\t\t|  2) Pilihan Metode Bank Mandiri                                     |");
            System.out.println("\t\t\t\t\t\t|                                                                     |");
            System.out.println("\t\t\t\t\t\t|---------------------------------------------------------------------|");
            System.out.print("\t\t\t\t\t\t|  Total Yang Harus Anda Bayar            = Rp ");
            total_bayar = scanner.nextDouble();
            System.out.print("\t\t\t\t\t\t|  No. Rekening Mandiri Sumber Pembayaran = ");
            String mandiri = scanner.next();
            System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------\n");

            // Display menu and process order
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.print("Pilih menu: ");
            int pilihanMenu = scanner.nextInt();
            int indexMenu = pilihanMenu - 1;

            if (indexMenu >= 0 && indexMenu < menu.length) {
                System.out.println("\t\t\t\t\t\t| Jumlah Yang Dibeli " + menu[indexMenu] + ": ");
                jumlah[indexMenu] = scanner.nextInt();
                System.out.println();
                subtotal[indexMenu] = jumlah[indexMenu] * harga_promo[indexMenu];
                total_bayar += subtotal[indexMenu];
                dibeli++;
            } else {
                scanner.nextLine(); // Clear input buffer
                System.out.println("\t\t\t\t\t\t\tMenu yang dipilih tidak tersedia.");
                System.out.println();
                continue;
            }

            // Your other code goes here, but translated into Java
            // For example:
            // Clear screen: System.out.print("\033[H\033[2J");
            // Pause: scanner.nextLine();
            // And so on...

            // Assuming bayar == 2 corresponds to non-cash payment
                System.out.println("\t\t\t\t\t\t+-----------------------------------------------------------------------+");
                System.out.println("\t\t\t\t\t\t|                            KopiKirin TB 1                             |");
                System.out.println("\t\t\t\t\t\t+-----------------------------------------------------------------------+\n");

                // Displaying payment methods
                System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------");
                System.out.println("\t\t\t\t\t\t|                    Pembayaran Non-Tunai (Cashless)                  |");
                System.out.println("\t\t\t\t\t\t|                                                                     |");
                System.out.println("\t\t\t\t\t\t|  2) Pilihan Metode Bank Mandiri                                     |");
                System.out.println("\t\t\t\t\t\t|                                                                     |");
                System.out.println("\t\t\t\t\t\t|---------------------------------------------------------------------|");
                // Displaying total payment
                System.out.println("\t\t\t\t\t\t|  Total Yang Harus Anda Bayar            = Rp " + total_bayar);
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t|  No. Rekening Mandiri Tujuan Pembayaran = 1511612345                 ");
                System.out.print("\t\t\t\t\t\t|  No. Rekening Mandiri Sumber Pembayaran = ");
                mandiri = scanner.nextLine();
                System.out.println("\t\t\t\t\t\t|                                                                     |");
                System.out.println("\t\t\t\t\t\t-----------------------------------------------------------------------");

                // Clearing screen and displaying receipt
                System.out.println("Clear screen and display receipt logic here...");

                // Exit loop
                break;
        }
    }
}