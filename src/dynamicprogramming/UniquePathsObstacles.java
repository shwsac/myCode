package dynamicprogramming;

public class UniquePathsObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m > 100 || n > 100) {
            return 0;
        }

        int[][] T = new int[m][n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        T[0][0] = 1;

        for (int i = 1; i < n; i++) {
            T[0][i] = (obstacleGrid[0][i] == 1 ? 0 : T[0][i - 1]);
        }

        for (int i = 1; i < m; i++) {
            T[i][0] = (obstacleGrid[i][0] == 1 ? 0 : T[i - 1][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = (obstacleGrid[i][j] == 1 ? 0 : (T[i - 1][j] + T[i][j - 1]));
            }
        }
        return T[m - 1][n - 1];
    }

}
