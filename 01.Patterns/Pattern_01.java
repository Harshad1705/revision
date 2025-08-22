import java.util.Scanner;

class Pattern_01{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}