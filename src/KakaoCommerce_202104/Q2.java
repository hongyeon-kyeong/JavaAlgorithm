package KakaoCommerce_202104;

import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //int[] needs = [ [ 1, 0, 0 ], [1, 1, 0], [1, 1, 0], [1, 0, 1], [1, 1, 0], [0, 1, 1] ];
        //int answer = sol.solution(needs,2);
        //System.out.println(answer);

    }

    static class Solution {
        ArrayList<ArrayList<Integer>> robots = new ArrayList<ArrayList<Integer>>();
        public int solution(int[][] needs, int r) {
            int max_value = 0;
            int n = needs[0].length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {

            }
            boolean[] visited = new boolean[n];

            //combination(arr, visited, 0, n, r);

            for (int i = 0; i < robots.size(); i++) {
                int answer = 0;
                ArrayList<Integer> robot = robots.get(i);
                for (int rr : robot) {
                    System.out.println("rr = " + rr);
                }
                ArrayList<Integer> impossible = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    boolean chk = false;
                    for (int k = 0; k < robot.size(); k++) {
                        if (robot.get(k) == j) {
                            chk = true;
                            break;
                        }
                    }
                    if (!chk) {
                        impossible.add(j);
                    }
                }
                for (int pop : impossible) {
                    System.out.println("pop = " + pop);
                }
                for (int j = 0; j < needs.length; j++) {
                    boolean isMake = true;
                    for (int k = 0; k < n; k++) {
                        if (needs[j][k] == 1) {
                            for (int t = 0; t < n - r; t++) {
                                if (impossible.get(t) == k) {
                                    isMake = false;
                                }
                            }
                        }
                    }
                    if (isMake) {
                        answer += 1;
                    }
                }
                if (answer > max_value) {
                    max_value = answer;
                }
            }
            return max_value;
        }

        public void combination(boolean[] visited, int start, int n, int r) {
            if(r == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        temp.add(i);
                    }
                }
                robots.add(temp);
                return;
            }

            for(int i=start; i<n; i++) {
                visited[i] = true;
                combination(visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }


}
