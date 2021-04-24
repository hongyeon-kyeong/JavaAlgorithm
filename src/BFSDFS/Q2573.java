package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2573 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static Queue<Index> waterQ, iceQ;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        waterQ = new LinkedList<>();
        iceQ = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            count += 1;
            melt();

            if (isAllMelt()) {
                System.out.println(0);
                break;
            }

            if (!isOneMass()) {
                System.out.println(count);
                break;
            }
        }
    }

    private static boolean isOneMass() {
        boolean[][] visited = new boolean[N][M];
        while (!iceQ.isEmpty()) {
            Index ice = iceQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] > 0) {
                        iceQ.offer(new Index(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isAllMelt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    iceQ.offer(new Index(i, j));
                    return false;
                }
            }
        }
        return true;
    }

    private static void melt() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    waterQ.offer(new Index(i, j));
                }
            }
        }

        while(!waterQ.isEmpty()) {
            Index water = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = water.x + dx[i];
                int ny = water.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] > 0) {
                        map[nx][ny] -= 1;
                    }
                }
            }
        }
    }

    static class Index {
        int x, y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
