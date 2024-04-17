package src;

import java.util.Scanner;

public class Task2 { // OK
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[][] matrix = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextLong();
            }
        }
        rotateMatrix(n, m, matrix);
    }

    public static void rotateMatrix(int n, int m, long[][] matrix) {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
