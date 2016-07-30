package dynamicprogramming;

public class UniquePathsNumber {

    public int uniquePaths(int m, int n) {

        if (m > 100 || n > 100) {
            return 0;
        }

        int[][] T = new int[m][n];
        T[0][0] = 1;

        for (int i = 1; i < n; i++) {
            T[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            T[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i - 1][j] + T[i][j - 1];
            }
        }
        return T[m - 1][n - 1];
    }

}
