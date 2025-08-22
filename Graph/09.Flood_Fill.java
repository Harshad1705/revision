// Leetcode - 733

class Pair{
    int row;
    int col;
    Pair(int r , int c){
        this.row = r;
        this.col = c;
    }
}
class Solution {


    void dfs(int r , int c , int n , int m, boolean[][] visited , int[][] image,int color,int pix){

        visited[r][c] = true;
        image[r][c] = color;

        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

         for(int i=0 ; i<4 ;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==pix && visited[nrow][ncol]==false ){
                    
                dfs(nrow,ncol,n,m,visited,image,color,pix);
            }
        }


    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        // Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // q.add(new Pair(sr,sc));

        int pix = image[sr][sc];

        // visited[sr][sc] = true;
        // image[sr][sc] = color;

        dfs(sr,sc,n,m,visited,image,color,pix);

        // int[] drow = {-1,0,+1,0};
        // int[] dcol = {0,+1,0,-1};
        
        // while(!q.isEmpty()){
        //     Pair p = q.remove();

        //     for(int i=0 ; i<4 ;i++){
        //         int nrow = p.row + drow[i];
        //         int ncol = p.col + dcol[i];

        //         if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==pix && visited[nrow][ncol]==false ){
        //             visited[nrow][ncol]=true;
        //             image[nrow][ncol] = color;
        //             q.add(new Pair(nrow,ncol));
        //         }
        //     }

        // }
        return image;     
    }
}

// Time Complexity - O(n*m)
// Space Complexity - O(n*m)