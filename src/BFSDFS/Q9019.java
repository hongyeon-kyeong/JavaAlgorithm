package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019 {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static String answer;
    static String[] cmd = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            answer = calculate(A, B);
            System.out.println(answer);
        }
    }

    private static String calculate(int a, int b) {
        Queue<Integer> numQ = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        numQ.offer(a);
        visited[a] = true;
        command[a] = "";

        while (!numQ.isEmpty()) {
            int curNum = numQ.poll();
            if (curNum == b) {
                return command[curNum];
            }

            for (int c = 0; c < 4; c++) {
                int nextNum = doCommand(curNum, cmd[c]);

                if (!visited[nextNum]) {
                    numQ.offer(nextNum);
                    visited[nextNum] = true;
                    command[nextNum] = command[curNum] + cmd[c];
                }
            }
        }
        return "";
    }

    private static int doCommand(int n, String cmd) {
        int result;
        if ("D".equals(cmd)) {
            result = cmdD(n);
        } else if ("S".equals(cmd)) {
            result = cmdS(n);
        } else if ("L".equals(cmd)) {
            result = cmdL(n);
        } else {
            result = cmdR(n);
        }
        return result;
    }

    private static int cmdR(int x) {
        x = (x % 10) * 1000 + x / 10;
        return x;
    }

    private static int cmdL(int x) {
        x = (x % 1000) * 10 + x / 1000;
        return x;
    }

    private static int cmdS(int x) {
        if (x == 0) {
            x = 9999;
        } else {
            x -= 1;
        }
        return x;
    }

    private static int cmdD(int x) {
        x *= 2;
        if (x > 9999) {
            x %= 10000;
        }
        return x;
    }
}
