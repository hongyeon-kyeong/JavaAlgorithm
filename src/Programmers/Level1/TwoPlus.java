package Programmers.Level1;

import java.util.Arrays;
import java.util.TreeSet;

public class TwoPlus {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        int[] answer = solution(numbers);
        Arrays.stream(answer).forEach(a -> System.out.println(a));

    }
    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                treeSet.add(numbers[i] + numbers[j]);
            }
        }
        return treeSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
