package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char direction = scanner.next().charAt(0);
        scanner.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        rotateMatrix(n, matrix, direction);
    }

    public static void rotateMatrix(int n, int[][] matrix, char direction) {
        List<String> operations = new ArrayList<>();
        if (direction == 'R') {
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                    operations.add(String.format("%d %d %d %d", i, j, n - 1 - j, i));
                    operations.add(String.format("%d %d %d %d", n - 1 - j, i, n - 1 - i, n - 1 - j));
                    operations.add(String.format("%d %d %d %d", n - 1 - i, n - 1 - j, j, n - 1 - i));
                }
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = temp;
                    operations.add(String.format("%d %d %d %d", i, j, j, n - 1 - i));
                    operations.add(String.format("%d %d %d %d", j, n - 1 - i, n - 1 - i, n - 1 - j));
                    operations.add(String.format("%d %d %d %d", n - 1 - i, n - 1 - j, n - 1 - j, i));
                }
            }
        }
        System.out.println(operations.size());
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}
