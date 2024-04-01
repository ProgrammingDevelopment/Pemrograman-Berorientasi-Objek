import java.util.*;

public class LatIf {
    public static void main(String[] args) {
        double tot_beli, potongan=0, jum_bayar=0;
        Scanner input = new Scanner(System.in);

        System.out.println("Total Pembelian Rp. ");
        tot_beli = input.nextDouble();
        if (tot_beli >= 500000)
            potongan = 0.15 * tot_beli;
        System.out.println("Besarnya Potongan Rp." + potongan);
        jum_bayar = tot_beli - potongan;
        System.out.println("jumlah yang harus dibayarkan Rp. " + jum_bayar);
    }
}