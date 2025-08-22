import java.util.Scanner;

class Pattern_08 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j< ((n-i)*2)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}