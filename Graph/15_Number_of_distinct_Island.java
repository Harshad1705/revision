package Graph;

// GFG - Number of Distinct Islands

// this question same ans Number of Island but in this we store the island into set and return length of set

import java.util.*;

class Solution {
    
    String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    
    void dfs(int row, int col , boolean[][] visited,int[][] grid , ArrayList<String> arr,int baseRow,int baseCol){
        
        visited[row][col] = true;
        
        arr.add(toString(row-baseRow,col-baseCol));
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[] dRow = {-1,0,+1,0};
        int[] dCol = {0,+1,0,-1};
        
        for(int i=0 ; i<4 ; i++){
            int nR = row + dRow[i];
            int nC = col + dCol[i];
            
            if(nR>=0 && nR<n && nC>=0 && nC<m && grid[nR][nC]==1 && visited[nR][nC]==false){
                dfs(nR,nC,visited,grid,arr,baseRow,baseCol);
            }
        }
    }
    

    int countDistinctIslands(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        
        boolean[][] visited = new boolean[n][m];
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        // n*m
        for(int i=0 ; i< n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    ArrayList<String> arr = new ArrayList<>();
                    // n*m*4
                    dfs(i,j,visited,grid,arr,i,j);
                    set.add(arr);
                }
            }
        }
        
        return set.size();
        
    }
}


// Time Complexity - O(n*m + (n*m))
// Space Complexity - O(n*m)