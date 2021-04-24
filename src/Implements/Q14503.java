package Implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = clean();
        System.out.println(answer);
    }

    private static int clean() {
        int cleanedArea = 1;
        int rotateCnt = 0;
        visited[r][c] = true;

        while (true) {

            int nd = rotate(d);
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            //System.out.println("현재 r : " + r + " c : " + c + " d : " + d);
            //System.out.println("전진 nr : " + nr + " nc : " + nc);

            if (map[nr][nc] == 0 && !visited[nr][nc]) {
                r = nr;
                c = nc;
                d = nd;
                visited[r][c] = true;
                cleanedArea += 1;
                rotateCnt = 0;
                continue;
            } else {
                d = nd;
                rotateCnt += 1;
            }

            if (rotateCnt == 4) {
                nr = r - dr[nd];
                nc = c - dc[nd];
                //System.out.println("nr : " + nr + " nc : " + nc);

                if (map[nr][nc] == 0) {
                    rotateCnt = 0;
                    r = nr;
                    c = nc;
                    continue;
                } else {
                    return cleanedArea;
                }
            }
        }

    }

    private static int rotate(int d) {
        d -= 1;
        if (d == -1) {
            return 3;
        }
        return d;
    }
}
