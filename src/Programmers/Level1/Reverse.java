package Programmers.Level1;

import java.util.ArrayList;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));

    }
    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> array = new ArrayList<>();

        while (true) {
            if (n < 3) {
                array.add(n);
                break;
            }
            array.add(n % 3);
            n /= 3;
        }

        int length = array.size();
        for (int i = 0; i < length; i++) {
            //System.out.println(array.get(i));
            answer += (Math.pow(3, length - i - 1) * array.get(i));
            //System.out.println(answer);
        }
        return answer;
    }

}