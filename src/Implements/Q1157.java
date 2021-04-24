package Implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1157 {
    static BufferedReader br;
    static char[] words;
    static int[] count = new int[26];
    static int max_value = 0;
    static char answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        words = br.readLine().toCharArray();
        for (int i = 0; i < words.length; i++) {

            int ialpha = (int) words[i];
            if (ialpha > 96) {
                count[ialpha - 32 - 65] += 1;
            } else {
                count[ialpha - 65] += 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (max_value < count[i]) {
                max_value = count[i];
                answer = (char) (i + 65);
            } else if (max_value == count[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
