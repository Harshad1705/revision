import java.util.Scanner;

class Pattern_18  {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = i; j >=0 ; j--) {
                char character = (char) (64+n-j) ;
                System.out.print(character + " " ); 
            }
        
            System.out.println();
        }
    }
}