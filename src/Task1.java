package src;

public class Task1 { //HE OK
    public static void main(String[] args) {
        int n = 8;
        int[] grades = {3, 4, 4, 4, 4, 5, 4, 5};
        System.out.println(maxFives(n, grades));  // Вывод: 4
    }

    public static int maxFives(int n, int[] grades) {
        int maxCount = -1;
        int currentCount = 0;

        for (int i = 0; i < n; i++) {
            if (grades[i] == 2 || grades[i] == 3) {
                currentCount = 0; // Обнуление currentCount после 2 или 3
            } else if (grades[i] == 5) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }
}

