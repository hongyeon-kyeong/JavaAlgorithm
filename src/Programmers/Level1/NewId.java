package src.Programmers.Level1;

//import static Programmers.Level1.Solution.*;

public class NewId {
    public static void main(String[] args) {
        System.out.println(Solution2.solution("...!@BaT#*..y.abcdefghijklm"));


    }
}
class Solution1 {
    public static String solution(String new_id) {
        String answer = new_id;
        answer = step_1(answer);
        //System.out.println("answer = " + answer);
        answer = step_2(answer);
        //System.out.println("answer = " + answer);
        answer = step_3(answer);
        //System.out.println("answer = " + answer);
        answer = step_4(answer);
        //System.out.println("answer = " + answer);
        answer = step_5(answer);
        //System.out.println("answer = " + answer);
        answer = step_6(answer);
        //System.out.println("answer = " + answer);
        answer = step_7(answer);
        //System.out.println("answer = " + answer);

        return answer;
    }

    private static String step_7(String answer) {
        if (answer.length() <= 2) {
            //System.out.println("answer : " + answer);
            //System.out.println("char : " + answer.charAt(answer.length()-1));
            answer = String.format("%-3s", answer).replace(' ', answer.charAt(answer.length() - 1));
        }
        return answer;
    }

    private static String step_6(String answer) {
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, 14);
        }
        return answer;
    }

    private static String step_5(String answer) {
        if (answer.equals("")) {
            answer = "a";
        }
        return answer;
    }

    private static String step_4(String answer) {
        char[] cAnswer = answer.toCharArray();
        if (cAnswer[0] == '.') {
            cAnswer[0] = '*';
        }
        if (cAnswer[cAnswer.length - 1] == '.') {
            cAnswer[cAnswer.length-1] = '*';
        }
        return String.valueOf(cAnswer).replace("*", "");
    }

    private static String step_3(String answer) {
        char[] cAnswer = answer.toCharArray();
        for (int i = 0; i < cAnswer.length-1; i++) {
            if (cAnswer[i] == '.' && cAnswer[i + 1] == '.') {
                cAnswer[i] = '*';
            }
        }
        return String.valueOf(cAnswer).replace("*", "");
    }

    private static String step_2(String answer) {
        char[] cAnswer = answer.toCharArray();
        for (int i = 0; i < cAnswer.length; i++) {
            int cNum = (int) cAnswer[i];
            if (cNum >= 97 && cNum <= 122) continue;
            if (cNum == 45 || cNum == 95 || cNum == 46) continue;
            if (cNum >= 48 && cNum <= 57) continue;
            cAnswer[i] = '*';
        }
        return String.valueOf(cAnswer).replace("*","");
    }

    private static String step_1(String answer) {
        return answer.toLowerCase();
    }
}
class Solution2 {
    public static String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();
        temp = temp.replaceAll("[^-_.0-9a-z]", "");
        temp = temp.replaceAll("[.]{2,}", ".");
        temp = temp.replaceAll("^[.]|[.]$", "");
        if (temp.equals("")) temp += "a";
        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("[.]$", "");
        }
        if (temp.length() <= 2) {
            while (temp.length() < 3) {
                temp += temp.charAt(temp.length() - 1);
            }
        }
        answer += temp;
        return answer;
    }
}