package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2589 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static char[][] map;
    static int max_value = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

//        for (int i = 0; i < N; i++) {
//            char[] temp = br.readLine().toCharArray();
//            for (int j = 0; j < M; j++) {
//                map[i][j] = temp[j];
//            }
//        }

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    int dist = findTreasure(i, j);
                    //System.out.println("i = " + i + " j = " + j + " dist : " + dist);
                    if (max_value < dist) {
                        max_value = dist;
                    }
                }
            }
        }
        System.out.println(max_value);
    }

    private static int findTreasure(int x, int y) {
        Queue<Index> landQueue = new LinkedList<>();
        int[][] visited = new int[N][M];
        landQueue.offer(new Index(x, y));
        visited[x][y] = 1; // 1로 초기화하고 마지막에 빼는 방법말고 다른 방법 없나 -> visited 여부 배열과 거리 배열을 따로 선
        int max = 0;

        while (!landQueue.isEmpty()) {
            Index curLand = landQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curLand.x + dx[i];
                int ny = curLand.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 'L') {
                        landQueue.offer(new Index(nx, ny));
                        visited[nx][ny] = visited[curLand.x][curLand.y] + 1;

                        if (max < visited[nx][ny]) {
                            max = visited[nx][ny];
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (visited[i][j] > max) {
//                    max = visited[i][j];
//                }
//            }
//        }

        return max-1;
    }

    static class Index {
        int x, y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
