package src.Programmers.Level1;

import java.util.SplittableRandom;

public class Keypad {
    static int[][] keypadPos = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2},
    };
    static int[] leftPos = {3, 0};
    static int[] rightPos = {3, 2};
    static String handside;

    static String answer = "";

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        handside = (hand.equals("right")) ? "R" : "L";


        for (int number : numbers) {
            String nextHand = pushKeypad(number);
            answer += nextHand;

            if (nextHand.equals("L")) {leftPos = keypadPos[number]; continue;}
            if (nextHand.equals("R")) {rightPos = keypadPos[number]; continue;}

        }
        return answer;
    }

    private static String pushKeypad(int num) {
        if (num == 1 || num == 4 || num == 7) return "L";
        if (num == 3 || num == 6 || num == 9) return "R";
        if (getDiff(leftPos, num) > getDiff(rightPos, num)) return "R";
        if (getDiff(leftPos, num) < getDiff(rightPos, num)) return "L";
        return handside;
    }

    private static int getDiff(int[] pos, int num) {
        return Math.abs(pos[0] - keypadPos[num][0]) + Math.abs(pos[1] - keypadPos[num][1]);
    }
}
