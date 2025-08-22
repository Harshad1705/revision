import java.util.ArrayList;
import java.util.Scanner;

class Adjacenecy_List {
    
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n, m;
            n = scn.nextInt();
            m = scn.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u, v;

                u = scn.nextInt();
                v = scn.nextInt();
                
                adj.get(u).add(v);
                adj.get(v).add(u);

            }

            for (int i = 0; i < n + 1; i++) {
                System.out.print(adj.get(i) + " ");
                System.out.println();
            }
        }
    }
}
