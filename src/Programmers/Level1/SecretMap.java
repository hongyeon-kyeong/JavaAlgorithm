package src.Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecretMap {
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        Arrays.stream(solution(n, arr1, arr2)).forEach(a -> System.out.println(a));
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }
        return result;
    }
    private static String[] mapToAnswer(int[][] secretMap) {
        String[] answer = new String[secretMap.length];
        for (int i = 0; i < secretMap.length; i++) {
            answer[i] = "";
        }
        for (int i = 0; i < secretMap.length; i++) {
            for (int j = 0; j < secretMap.length; j++) {
                if (secretMap[i][j] >= 1) answer[i] += "#";
                else answer[i] += " ";
            }
        }
        return answer;
    }

    private static int[][] sumMap(int[][] map1, int[][] map2) {
        int[][] newMap = new int[map1.length][map2.length];
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1.length; j++) {
                newMap[i][j] = map1[i][j] + map2[i][j];
            }
        }
        return newMap;
    }

    private static int[] toBinaryNum(int x, int n) {
        ArrayList<Integer> bin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bin.add(x%2);
            x /= 2;
        }
        Collections.reverse(bin);
        return bin.stream().mapToInt(Integer :: intValue).toArray();
    }
}
