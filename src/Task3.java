package src;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, TreeSet<String>> directories = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] path = scanner.nextLine().split("/");
            for (int j = 0; j < path.length - 1; j++) {
                String key = String.join("/", Arrays.copyOfRange(path, 0, j + 1));
                String value = path[j + 1];
                if (!directories.containsKey(key)) {
                    directories.put(key, new TreeSet<>());
                }
                directories.get(key).add(value);
            }
        }
        printDirectories(directories, "", 0);
    }

    public static void printDirectories(TreeMap<String, TreeSet<String>> directories, String current, int indent) {
        if (directories.containsKey(current)) {
            for (String dir : directories.get(current)) {
                for (int i = 0; i < indent; i++) {
                    System.out.print("  ");
                }
                System.out.println(dir);
                printDirectories(directories, current.isEmpty() ? dir : current + "/" + dir, indent + 1);
            }
        }
    }
}