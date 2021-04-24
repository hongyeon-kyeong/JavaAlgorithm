package DevMatching_202104;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[] answer = new int[3];
        answer = sol.solution(3, 3, arr);
        for (int a : answer) {
            System.out.println("answer = " + a);
        }
    }
    static class Solution {
        int[][] map;
        public int[] solution(int rows, int columns, int[][] queries) {
            map = new int[rows][columns];
            int value = 1;
            ArrayList<Integer> tempAnswer = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j<columns; j++) {
                    map[i][j] = value;
                    value += 1;
                }
            }

            for (int[] query : queries) {
                int min_value = rotate(map, rows, columns, query);
                tempAnswer.add(min_value);
            }

            int[] answer = new int[queries.length];
            for (int i=0; i<queries.length; i++) {
                answer[i] = tempAnswer.get(i);
            }
            return answer;
        }

        private int rotate(int[][] map, int r, int c, int[] query) {
            //System.out.println("query = " +query);

            int min_value = 100001;
            int[][] temp = new int[r][c];
            for (int i = 0; i<r; i++) {
                for (int j = 0; j <c; j++) {
                    if ((i < query[2] && i >= query[0]-1) && (j < query[3] && j>= query[1]-1))  {
                        if (i == query[0]-1 && j!=query[1]-1) {
                            temp[i][j] = map[i][j-1];
                        } else if (j == query[3]-1) {
                            temp[i][j] = map[i-1][j];
                        } else if (i == query[2]-1) {
                            temp[i][j] = map[i][j+1];
                        } else if (j == query[1]-1) {
                            temp[i][j] = map[i+1][j];
                        } else {
                            temp[i][j] = map[i][j];
                        }

                        if (min_value > map[i][j]) {
                            min_value = map[i][j];
                        }

                    } else {
                        temp[i][j] = map[i][j];
                    }
                }
            }

            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    map[i][j] = temp[i][j];
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            return min_value;
        }
    }
}
