package src;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task6 {
    private static final int[][] KNIGHT_MOVES = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static final int[][] KING_MOVES = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] board = new char[n][n];
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'F') {
                    endX = i;
                    endY = j;
                }
            }
        }
        System.out.println(minMoves(n, board, startX, startY, endX, endY));
    }

    public static int minMoves(int n, char[][] board, int startX, int startY, int endX, int endY) {
        int[][][] dist = new int[n][n][2];
        for (int[][] row : dist) {
            for (int[] cell : row) {
                Arrays.fill(cell, Integer.MAX_VALUE);
            }
        }
        dist[startX][startY][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int type = current[2];
            int[][] moves = type == 0 ? KNIGHT_MOVES : KING_MOVES;
            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && board[newX][newY] != 'W') {
                    int newType = type;
                    if (board[newX][newY] == 'K') {
                        newType = 0;
                    } else if (board[newX][newY] == 'G') {
                        newType = 1;
                    }
                    if (dist[newX][newY][newType] == Integer.MAX_VALUE) {
                        dist[newX][newY][newType] = dist[x][y][type] + 1;
                        queue.offer(new int[]{newX, newY, newType});
                    }
                }
            }
        }
        int minMoves = Math.min(dist[endX][endY][0], dist[endX][endY][1]);
        return minMoves != Integer.MAX_VALUE ? minMoves : -1;
    }
}