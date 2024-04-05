public class nestedFor {
    public static void main(String[] args) 
    {
        int a, b;
        for(a = 1; a <= 5; a++) {

            System.out.println();
            for(b =a; b <= 5; b++) {
                System.out.println(a);
            }
        }
        System.out.println("\n");
    }
}