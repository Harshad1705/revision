package Graph;

import java.util.*;

// Time Complexity = O(N) + O(2*E)
// Space Complexity = O(N)

class DFS {


    static void dfs(int startIndex , ArrayList<ArrayList<Integer>> adj , boolean[] visited) {

        visited[startIndex] = true;
        
        System.out.print(startIndex + " ");

        for (Integer neighbour : adj.get(startIndex)) {
            if (!visited[neighbour]) {
                dfs(neighbour,adj,visited);
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n, m;
        n = scn.nextInt();
        m = scn.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

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
        
        dfs(1,adj,visited);
    }
    
}
