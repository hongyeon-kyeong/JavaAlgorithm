package src.Programmers.Level1;

public class Dart {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }

    public static int solution(String dartResult) {

        int[] answer_arr = new int[3];
        int idx = 0;
        int intCnt = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            int numericValue = Character.getNumericValue(c);
            if (numericValue >= 0 && numericValue <= 10) {
                if (numericValue == 1) {
                    if (Character.getNumericValue(dartResult.charAt(i + 1)) == 0) {
                        numericValue = 10;
                        i++;
                    }
                }

                answer_arr[idx] = numericValue;
                intCnt++;
            } else {
                switch (c) {
                    case 'S':
                        answer_arr[idx] = (int) Math.pow(answer_arr[idx], 1);
                        idx++;
                        break;
                    case 'D':
                        answer_arr[idx] = (int) Math.pow(answer_arr[idx], 2);
                        idx++;
                        break;
                    case 'T':
                        answer_arr[idx] = (int) Math.pow(answer_arr[idx], 3);
                        idx++;
                        break;
                    case '*':
                        idx = idx - 2 < 0 ? 0 : idx - 2;
                        while (idx < intCnt) {
                            answer_arr[idx] *= 2;
                            idx++;
                        }
                        break;
                    case '#':
                        answer_arr[idx - 1] *= (-1);
                        break;
                }
            }
        }
        return answer_arr[0] + answer_arr[1] + answer_arr[2];
    }
}
