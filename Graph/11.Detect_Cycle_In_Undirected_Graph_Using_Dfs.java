package Graph;

// GFG - Undirected Graph Cycle

import java.util.*;

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // if (bfsHasCycle(i, adj, visited)) {
                //     return true; 
                // }
                if(dfsHasCycle(i,-1,adj,visited)){
                    return true;
                }
            }
        }

        return false; 
    }

    boolean bfsHasCycle(int start, List<List<Integer>> adj, boolean[] visited) {
       
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsHasCycle(int start,int parent, List<List<Integer>> adj, boolean[] visited) {
       
        visited[start] = true;
        for(int i : adj.get(start)){
            if(visited[i]==false){
                if(dfsHasCycle(i,start,adj,visited))
                    return true;
            }else if(i!=parent){
                return true;
            }
        }
        return false;
    }
}

// Space Complexity - O(N)
// Time Complexity - O(N+2E)