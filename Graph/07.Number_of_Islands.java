// Leetcode - 200
class Solution {

    public void dfs(int row,int col , int n , int m , boolean[][] visited,char[][] grid){

        visited[row][col] = true;

        if(row-1 >= 0  && grid[row-1][col]=='1' && visited[row-1][col]==false){
            dfs(row-1,col,n,m,visited,grid);
        }
        if(row+1 < n && grid[row+1][col]=='1' &&visited[row+1][col]==false){
            dfs(row+1,col,n,m,visited,grid);
        }
        if(col-1 >= 0 && grid[row][col-1]=='1' && visited[row][col-1]==false){
            dfs(row,col-1,n,m,visited,grid);
        }
        if(col+1 < m && grid[row][col+1]=='1' && visited[row][col+1]==false){
            dfs(row,col+1,n,m,visited,grid);
        }

    }


    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;


        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    dfs(i,j,n,m,visited,grid);
                    count++;
                }
            }
        }

        return count;
        
    }
}