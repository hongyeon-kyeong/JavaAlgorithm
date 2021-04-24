package BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Q3055 {
    static int R, C;
    static BufferedReader br;
    static StringTokenizer st;
    static char[][] graph;
    static boolean[][] visitedH, visitedW;
    static Queue<Index> waters, hedgehogs;
    static Index FINISH;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visitedH = new boolean[R][C];
        visitedW = new boolean[R][C];

        waters = new LinkedList<>();
        hedgehogs = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph[i][j] = temp[j];
                if (graph[i][j] == 'S') {
                    hedgehogs.add(new Index(i, j));
                    visitedH[i][j] = true;
                } else if (graph[i][j] == '*') {
                    waters.add(new Index(i, j));
                    visitedW[i][j] = true;
                } else if (graph[i][j] == 'D') {
                    FINISH = new Index(i, j);
                }
            }
        }
        int answer = solution();
        if (answer == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    public static class Index {
        int x, y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void waterMove() {
        int len = waters.size();

        for (int t = 0; t < len; t++) {
            Index water = waters.poll();

            for (int d = 0; d < 4; d++) {
                int nx = water.x + dx[d];
                int ny = water.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if ( graph[nx][ny] != 'X' && graph[nx][ny] != 'D' && !visitedW[nx][ny]) {
                        graph[nx][ny] = '*';
                        waters.add(new Index(nx, ny));
                        visitedW[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static int solution() {

        int count = 0;

        while (!hedgehogs.isEmpty()) {
            waterMove();
            count++;

            int len = hedgehogs.size();
            for (int t = 0; t < len; t++) {

                Index hedgehog = hedgehogs.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = hedgehog.x + dx[i];
                    int ny = hedgehog.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {

                        if (nx == FINISH.x && ny == FINISH.y) {
                            return count;
                        }

                        if (graph[nx][ny] == '.' && visitedH[nx][ny]) {
                            hedgehogs.add(new Index(nx, ny));
                            visitedH[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
