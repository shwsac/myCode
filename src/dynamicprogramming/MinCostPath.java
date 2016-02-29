package dynamicprogramming;

public class MinCostPath {

    public int minPathSum(int[][] grid) {
        int m = -1;
        for(int[] i:grid) {
            m++;
        }
        int n = grid[0].length-1;
        if(n<1) {
            return grid[0][0];
        }
     
        int tc[][] = new int[m+1][n+1];
        tc[0][0] = grid[0][0];
        for(int i = 1; i<= m; i++) {
            tc[i][0] = tc[i-1][0] + grid[i][0];
        }
        
        for(int j = 1; j<= n; j++) {
            tc[0][j] = tc[0][j-1] + grid[0][j];
        }
        
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <=n; j++) {
                tc[i][j] = Math.min(tc[i-1][j], tc[i][j-1]) + grid[i][j];
            }
        }
        return tc[m][n];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
