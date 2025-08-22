package Graph;

// Leetcode -  785

import java.util.*;

class Solution {

    public boolean bfs(int startIndex , int[][] graph , int[] color){
        
        Queue<Integer> q = new LinkedList<>();
        // add start index in queue
        q.add(startIndex);

        // color it with first color
        color[startIndex] = 0;

        while(!q.isEmpty()){
            int index = q.remove();

            for (int i : graph[index]) {
                
                // if node is not coloured
                if (color[i] == -1) {
                    // color it with opposite color
                    color[i] = 1 - color[index];
                    // add node in queue
                    q.add(i);
                    // if it has same color of base node
                }else if(color[index]==color[i]){
                        return false;      
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }

        // for all the node
        for (int i = 0; i < n; i++) {
            // if it is not colored
            if(color[i]==-1){
                boolean ans = bfs(i,graph,color);
                if(ans == false){
                    return false;
                }
            }
        }

        return true;
        
    }
}

// Time Complexity = O(N) + O(2*E)
// Space Complexity = O(N)