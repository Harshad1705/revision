package Graph;

// Leetcode -  785


class Solution {

    public boolean dfs(int startIndex, int col, int[][] graph, int[] color) {

        // color with first color
        color[startIndex] = col;

        // for all the adjacent nodes
        for (int i : graph[startIndex]) {

            // if it is not colored
            if (color[i] == -1) {
                // call tp check with node with different color
                boolean res =  dfs(i,1-col,graph,color);
                if (!res)
                    return false;
                // if adjacent node has same color of node
            }else if(color[i] == color[startIndex]){
                return false;
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
            // if it is not coloured
            if(color[i]==-1){
                boolean ans = dfs(i,0,graph,color);
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