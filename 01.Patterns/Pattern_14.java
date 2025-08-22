import java.util.Scanner;

class Pattern_14 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

        for (int i = 0; i< n ; i++) {
            for (int j = 0; j < i+1; j++) {
                char character = (char) (65+j) ;
                System.out.print(character + " ");       
            }
            System.out.println();
        }
    }
}