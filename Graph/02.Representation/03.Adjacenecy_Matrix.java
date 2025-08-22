import java.util.*;;

class Adjacenecy_Matrix {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n, m;
        n = scn.nextInt();
        m = scn.nextInt();

        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u, v;
            u = scn.nextInt();
            v = scn.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1;

        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
