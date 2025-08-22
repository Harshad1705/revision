package Graph;

import java.util.*;

// Leetcode - 1020


class Pair {
    int row;
    int col;

    Pair(int i, int j) {
        row = i;
        col = j;
    }
}

class Solution {

    void dfs(int i, int j, boolean[][] visited, int[][] borad, int n, int m) {

        // mark that cell to visited
        visited[i][j] = true;

        int[] dRow = {-1,0,+1,0};
        int[] dCol = { 0, +1, 0, -1 };

        // checking its adjacent cells
        for(int k=0;k<4 ; k++){
            int nRow = i + dRow[k];
            int nCol = j + dCol[k];

            // if it in range and value is 'O' and is not visited and call dfs again
            if(nRow >=0 && nRow < n && nCol >=0 && nCol < m  && borad[nRow][nCol]==1 && visited[nRow][nCol]==false){
                dfs(nRow,nCol,visited,borad,n,m);
            }
        }
    }

    public int numEnclaves(int[][] board) {


        int n = board.length;
        int m = board[0].length;

        int count = 0;

        boolean[][] visited = new boolean[n][m];

        // traverse om row
        for (int i = 0; i < m; i++) {
            // first row
            if (board[0][i] == 1) {
                dfs(0, i, visited, board, n, m);
            }
            // last row
            if (board[n - 1][i] == 1) {
                dfs(n - 1, i, visited, board, n, m);
            }
        }

        // traverse on column
        for (int i = 0; i < n; i++) {
            // first col
            if (board[i][0] == 1) {
                dfs(i, 0, visited, board, n, m);
            }
            // last col
            if (board[i][m - 1] == 1) {
                dfs(i, m - 1, visited, board, n, m);
            }
        }

        // traverse on board and if value is 'O' and is not visited convert it to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && visited[i][j] == false) {
                    count++;
                }
            }
        }

        return count;

    }

    void bfs(int i , int j ,boolean[][] visited ,int[][] borad ,int n , int m ){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));

        while(!q.isEmpty()){

            Pair p = q.remove();

            System.out.println(p.row + " " + p.col);

            int[] dRow = {-1,0,+1,0};
            int[] dCol = { 0, +1, 0, -1 };

            // checking its adjacent cells
            for(int k=0 ; k < 4 ; k++){
                int nRow = p.row + dRow[k];
                int nCol = p.col + dCol[k];

                // if it in range and value is 'O' and is not visited and call dfs again
                if(nRow >=0 && nRow < n && nCol >=0 && nCol < m  && visited[nRow][nCol]==false && borad[nRow][nCol]==1 ){
                    q.add(new Pair(nRow,nCol));
                }
            }
        }
    }

}


// Time Complexity - O(n*m)
// Space Complexity - O(n*m)