import java.util.Scanner;

class Pattern_22 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = scn.nextInt();

  

        for (int i = 0; i < 2*n-1; i++) {
            for (int j = 0; j < 2*n - 1; j++) {
                int top = i;
                int bottom = (2*n - 2) - i;
                int left = j;
                int right = (2*n - 2) - j;

                System.out.print(n - Math.min(Math.min(top,bottom),Math.min(left,right)));
            }
            System.out.println();
        }
 
    }
}