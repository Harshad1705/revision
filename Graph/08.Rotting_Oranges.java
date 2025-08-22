// Leetcode 994

import java.util.*;
class Pairs{
    int row;
    int col;
    int value;

    Pairs(int row , int col , int value){
        this.row=  row;
        this.col = col;
        this.value = value;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // SC - n*m
        Queue<Pairs> q = new LinkedList<>();
        // SC - n*m
        boolean[][] visited = new boolean[n][m];

        int fresh = 0;

        // TC - n*m
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==2){
                    visited[i][j] = true;
                    Pairs p = new Pairs(i,j,0);
                    q.add(p);
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int count = 0;

        int[] drow = { -1 , 0, +1 , 0};
        int[] dcol = { 0 ,1 , 0 , -1};

        int freshCnt = 0;

        // TC - n*m
        while(!q.isEmpty()){

            Pairs front = q.remove();
            count = Math.max(count,front.value);


            // TC - 4
            for(int i=0 ; i<4 ; i++){

                int nrow = front.row + drow[i];
                int ncol = front.col + dcol[i];
                int val = front.value;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==false){
                    grid[nrow][ncol] = 2;
                    visited[nrow][ncol] = true;
                    q.add(new Pairs(nrow,ncol,val+1));
                    freshCnt++;

                }

            }

            // // top
            // if(front.row-1 >=0 && grid[front.row-1][front.col]==1 && visited[front.row-1][front.col]==false){
            //     grid[front.row-1][front.col] = 2;
            //     visited[front.row-1][front.col] = true;
            //     q.add(new Pairs(front.row-1,front.col,front.value+1));
            // }
            // // bottom
            // if(front.row+1 < n && grid[front.row+1][front.col]==1 && visited[front.row+1][front.col]==false){
            //     grid[front.row+1][front.col] = 2;
            //     visited[front.row+1][front.col] = true;
            //     q.add(new Pairs(front.row+1,front.col,front.value+1));
            // }
            // // left
            // if(front.col-1 >= 0 && grid[front.row][front.col-1]==1 && visited[front.row][front.col-1]==false){
            //     grid[front.row][front.col-1] = 2;
            //     visited[front.row][front.col-1] = true;
            //     q.add(new Pairs(front.row,front.col-1,front.value+1));
            // }
            // // right
            // if(front.col+1 < m && grid[front.row][front.col+1]==1 && visited[front.row][front.col+1]==false){
            //     grid[front.row][front.col+1] = 2;
            //     visited[front.row][front.col+1] = true;
            //     q.add(new Pairs(front.row,front.col+1,front.value+1));
            // }

        }

        if(fresh!=freshCnt){
            return -1;
        }

        // for(int i=0 ; i<n ; i++){
        //     for(int j=0 ; j<m ; j++){
        //         if(grid[i][j]==1){
        //             return -1;
        //         }
        //     }
        // }

        return count;

        
    }
}

// Space Complexity - O(n*m)
// Time Complexity - O(n*m)