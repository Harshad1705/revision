package Graph;

import java.util.*;

// Time Complexity = O(N) + O(2*E)
// Space Complexity = O(N)

class BFS {

    static void bfs(ArrayList<ArrayList<Integer>> adj, int startIndex , int nodes) {
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedArray = new boolean[nodes + 1];

        q.add(startIndex);
        visitedArray[startIndex] = true;

        while (!q.isEmpty()) {  
            
            Integer front = q.peek();
            q.remove();

            for (Integer neighbour : adj.get(front)) {
                if (visitedArray[neighbour]==false) {
                    q.add(neighbour);
                    visitedArray[neighbour] = true;
                }
            }

            System.out.print(front + " ");
        }

    }

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
            bfs(adj,1 , n);
        }
    }
    
}
