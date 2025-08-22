package Graph;

// Leetcode - 542

import java.util.*;

class Pair{
    int row;
    int col;
    int distance;
    Pair(int i , int j , int k){
        row = i;
        col = j;
        distance = k;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] result = new int[n][m];

        // n*m
        // adding all cell in queue having value 0
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(mat[i][j]==0)
                    q.add(new Pair(i,j,0));
            }
        }

        int[] dRow = {-1,0,+1,0};
        int[] dCol = { 0, +1, 0, -1 };

        // n*m
        // perform till queue is not empty 
        while(!q.isEmpty()){

            Pair front = q.remove();
            int i = front.row;
            int j = front.col;
            int dis = front.distance;

            // if cell is not visited
            if(visited[i][j]==false){

                visited[i][j] = true;
                result[i][j] = dis;

                // checking its adjavent element
                for(int k=0 ; k<4 ; k++){
                    int nRow = i + dRow[k];
                    int nCol = j + dCol[k];

                    // if they r not visited add in queue with distenace +1
                    if(nRow >=0 && nRow < n && nCol >=0 && nCol < m && visited[nRow][nCol]==false){
                        q.add(new Pair(nRow,nCol,dis+1));
                    }
                }
            }
        }

        return result;
        
    }
}

// Time Complexity - O(n*m)
// Space Complexity - O(n*m)