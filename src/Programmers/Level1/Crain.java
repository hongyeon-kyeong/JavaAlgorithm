package Programmers.Level1;


import java.util.ArrayList;
import java.util.Stack;

public class Crain {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
        //System.out.println(solution2(board, moves));

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        int m = moves.length;

        ArrayList<Integer> basket = new ArrayList<>();

        basket.add(0);
        for (int i = 0; i < m; i++) {
            int col = moves[i];
            int row = 0;
            while (row < n && board[row][col - 1] == 0) {
                row += 1;
            }
            if (row < n) {
                basket.add(board[row][col - 1]);
                board[row][col - 1] = 0;
                int idx = basket.size()-1;
                if (basket.get(idx) == basket.get(idx - 1)) {
                    answer += 2;
                    basket.remove(idx);
                    basket.remove(idx - 1);
                }
            }
        }
        return answer;
    }
    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}