package KakaoCommerce_202104;

import java.util.Arrays;

public class Q1 {
    class Solution {
        public int solution(int[] gift_cards, int[] wants) {
            Arrays.sort(gift_cards);
            boolean[] visited = new boolean[gift_cards.length];
            boolean chk;
            int answer = 0;

            for (int want : wants) {
                chk = binary_search(gift_cards, want, visited);
                if (!chk) {
                    answer += 1;
                }
            }
            return answer;
        }
        private boolean binary_search (int[] arr, int key, boolean[] visited) {
            int mid;
            int left = 0;
            int right = arr.length - 1;

            while (right >= left) {
                mid = (left + right) / 2;
                if (key == arr[mid] && !visited[mid]) {
                    visited[mid] = true;
                    return true;
                }
                if (key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
