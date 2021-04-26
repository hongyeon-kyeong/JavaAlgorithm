package src.Programmers.Level1;

public class Keypad {
    static int[] keypadX = {3, 0, 0, 0, 1, 1, 1, 2, 2, 2};
    static int[] keypadY = {1, 0, 1, 2, 0, 1, 2, 0, 1, 2};
    static int rightPx = 3;
    static int rightPy = 2;
    static int leftPx = 3;
    static int leftPy = 0;
    static String answer = "";

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
    public static String solution(int[] numbers, String hand) {

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (keypadY[number] == 0) {
                pushKeypad("L", keypadX[number], keypadY[number]);
                continue;
            }
            if (keypadY[number] == 2) {
                pushKeypad("R", keypadX[number], keypadY[number]);
                continue;
            }
            if (keypadY[number] == 1) {
                int leftDiff = getDiff(leftPx, leftPy, keypadX[number], keypadY[number]);
                int rightDiff = getDiff(rightPx, rightPy, keypadX[number], keypadY[number]);
                if (leftDiff < rightDiff) {
                    pushKeypad("L", keypadX[number], keypadY[number]);
                } else if (rightDiff < leftDiff) {
                    pushKeypad("R", keypadX[number], keypadY[number]);
                } else {
                    if (hand.equals("left")) {
                        pushKeypad("L", keypadX[number], keypadY[number]);
                    } else {
                        pushKeypad("R", keypadX[number], keypadY[number]);
                    }
                }
            }

        }

        return answer;
    }

    private static void pushKeypad(String hand, int nx, int ny) {
        answer += hand;
        if ("L".equals(hand)) {
            leftPx = nx;
            leftPy = ny;
        } else {
            rightPx = nx;
            rightPy = ny;
        }
    }

    private static int getDiff(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
