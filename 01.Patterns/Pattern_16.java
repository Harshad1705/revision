import java.util.Scanner;

class Pattern_16  {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 1; i<= n ; i++) {
            for (int j = 0; j<i ; j++) {
                char character = (char) (64+(i)) ;
                System.out.print(character + " ");       
            }
            System.out.println();
        }
    }
}