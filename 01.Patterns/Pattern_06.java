import java.util.Scanner;

class Pattern_06{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j<= n-i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}