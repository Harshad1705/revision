import java.util.Scanner;

class Pattern_17  {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                System.out.print("  ");
            }
            int x = (2 * i) + 1;
            int y = (x + 1) / 2;
            int j = 0;
            for ( j = 0; j<y ; j++) {
                 char character = (char) (65+(j)) ;
                System.out.print(character + " " );       
            }
            j--;
            j--;
            for (; j >= 0; j--) {
                char character = (char) (65+(j)) ;
                System.out.print(character + " " );  
            }
            System.out.println();
        }
    }
}