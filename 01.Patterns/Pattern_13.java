import java.util.Scanner;

class Pattern_13 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++ ) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }
}