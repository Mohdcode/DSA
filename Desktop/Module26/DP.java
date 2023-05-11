import java.io.*;

public class DP {
    public static int Fib(int n,int []f){//memoization in DP
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){//if array index for call n is not empty then it has already been calculated so no need to go further just take it from here
            return f[n];
        }

        f[n]= Fib(n-1,f)+Fib(n-2,f);

        return f[n];
    }

    public static int FibTabulation(int n){//tabulation form
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];

        }return dp[n];
    }
    public static int knapsack(int c, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][c + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][c];
    }



    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }


    public static int longestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;  // variable to store the length of the longest common substring

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;  // reset the length if characters do not match
                }
            }
        }

        return maxLength;
    }


    public static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        int[] dp = new int[W + 1];

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }

        return dp[W];
    }


    public static int maxSubArraySum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] stores the maximum subarray sum ending at index i
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static long catalan(int n) {
        if (n <= 1) {
            return 1;
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static int maxPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];

        // Fill the first row
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // Fill the first column
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // Fill the remaining cells
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }


    public static int maxSquareSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSquareSize = 0;

        // Copy the first row and first column as is
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            maxSquareSize = Math.max(maxSquareSize, dp[i][0]);
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            maxSquareSize = Math.max(maxSquareSize, dp[0][j]);
        }

        // Compute the maximum square submatrix size
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSquareSize = Math.max(maxSquareSize, dp[i][j]);
                }
            }
        }

        return maxSquareSize * maxSquareSize;
    }


    public static void main(String[] args) {
int n=5;
int []f=new int [n+1];
System.out.println(Fib(n,f));
        System.out.println(FibTabulation(n));

    }

}
