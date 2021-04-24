package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    static int M, N;
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Index> tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        tomato = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    //System.out.println("i = " + i + " j = " + j);
                    tomato.offer(new Index(i, j));
                    visited[i][j] = true;
                }
            }
        }

        ripe();
        if (isAllRipen()){
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isAllRipen() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void ripe() {
        while (!tomato.isEmpty()) {
            int len = tomato.size();
            //System.out.println("------------------------");
            for (int i = 0; i < len; i++) {
                Index pTomato = tomato.poll();
                //System.out.println("pTomato.x = " + pTomato.x + "pTomato.y =" + pTomato.y);
                for (int d = 0; d < 4; d++) {
                    int nx = pTomato.x + dx[d];
                    int ny = pTomato.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        //if (!visited[nx][ny] && map[nx][ny] == 0) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            //visited[nx][ny] = true;
                            tomato.offer(new Index(nx, ny));
                        }
                    }
                }
            }
            if (tomato.size() > 0) {
                count += 1;
            }
        }
    }

    public static class Index {
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
