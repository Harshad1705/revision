import java.util.Scanner;

class Pattern_11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((i + j) % 2 == 0 ? "0" : "1");
            }
            System.out.println();
        }
    }
}