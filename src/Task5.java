package src;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] forest = new char[n][3];
        for (int i = 0; i < n; i++) {
            forest[i] = scanner.nextLine().toCharArray();
        }
        System.out.println(maxMushrooms(n, forest));
    }

    public static int maxMushrooms(int n, char[][] forest) {
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = forest[0][i] == 'C' ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (forest[i][j] != 'W') {
                    int mushrooms = forest[i][j] == 'C' ? 1 : 0;
                    for (int k = Math.max(0, j - 1); k <= Math.min(2, j + 1); k++) {
                        if (forest[i - 1][k] != 'W') {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + mushrooms);
                        }
                    }
                }
            }
        }
        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
