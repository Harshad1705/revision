package Graph;

// Leetcode - 130

class Solution {

    // n*m*4
    void dfs(int i, int j, boolean[][] visited, char[][] borad, int n, int m) {

        // mark that cell to visited
        visited[i][j] = true;

        int[] dRow = {-1,0,+1,0};
        int[] dCol = { 0, +1, 0, -1 };

        // checking its adjacent cells
        for(int k=0;k<4 ; k++){
            int nRow = i + dRow[k];
            int nCol = j + dCol[k];

            // if it in range and value is 'O' and is not visited and call dfs again
            if(nRow >=0 && nRow < n && nCol >=0 && nCol < m  && borad[nRow][nCol]=='O' && visited[nRow][nCol]==false){
                dfs(nRow,nCol,visited,borad,n,m);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // traverse om row
        for (int i = 0; i < m; i++) {
            // first row
            if (board[0][i] == 'O') {
                dfs(0, i, visited, board, n, m);
            }
            // last row
            if (board[n - 1][i] == 'O') {
                dfs(n - 1, i, visited, board, n, m);
            }
        }

        // traverse on column
        for (int i = 0; i < n; i++) {
            // first col
            if (board[i][0] == 'O') {
                dfs(i, 0, visited, board, n, m);
            }
            // last col
            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, visited, board, n, m);
            }
        }

        // traverse on board and if value is 'O' and is not visited convert it to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
        
        
    }
}

// Time Complexity - O(n*m)
// Space Complexity - O(n*m)