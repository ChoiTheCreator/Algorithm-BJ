import java.io.*;
import java.util.*;

public class Main {
    static int cnt1 = 0;
    static int cnt2 = 0;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        matrixPathRec(n, n);
        matrixPathDP(n);
        cnt1++;

        System.out.println(cnt1 + " " + cnt2);
    }

    static int matrixPathRec(int i, int j) {

        if (i == 0 || j == 0) {
            return 0;
        } else {
            cnt1++;
            return matrix[i][j] + Math.max(matrixPathRec(i-1, j), matrixPathRec(i, j-1));
        }
    }

    static void matrixPathDP(int n) {
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cnt2++;
                dp[i][j] = matrix[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
}