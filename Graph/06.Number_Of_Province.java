package Graph;

// Leetcode 547

import java.util.*;

class Solution {

    void dfs(int startIndex , ArrayList<ArrayList<Integer>> adj , boolean[] visited){

        visited[startIndex] = true;

        for(Integer neighBour : adj.get(startIndex)){
            if(visited[neighBour]==false){
                dfs(neighBour,adj,visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<isConnected[i].length ; j++){
                int value = isConnected[i][j];
                if(value==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;

        for(int i=0 ; i<n ; i++){
            if(visited[i]==false){
                dfs(i,adj,visited);
                count++;
            }
        }

        return count;  
    }
}

// Space Complexity - O(N) + O(N)
// Time Complexity - O(N) * O(V+2E)