package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2146 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] map;
    static Queue<Index> islandQ = new LinkedList<>();
    static int answer = 10001;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandIdx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandQ.offer(new Index(i, j));
                    visited[i][j] = true;
                    map[i][j] = islandIdx;
                    markIsland(islandIdx);
                    islandIdx += 1;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    int dist = makeBridge(i, j, map[i][j]);
                    if (dist < answer) {
                        answer = dist;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int makeBridge(int x, int y, int startIdx) {
        Queue<Index> seaQ = new LinkedList<>();
        int[][] seaVisited = new int[N][N];
        seaQ.offer(new Index(x, y));
        seaVisited[x][y] = 1;
        int min_value = 10001;

        while (!seaQ.isEmpty()) {
            Index curPos = seaQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curPos.x + dx[d];
                int ny = curPos.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] > 0 && map[nx][ny] != startIdx) {
                        if (seaVisited[curPos.x][curPos.y] < min_value) {
                            min_value = seaVisited[curPos.x][curPos.y];
                        }
                    }
                    if (seaVisited[nx][ny] == 0 && map[nx][ny] == 0) {
                        seaQ.offer(new Index(nx, ny));
                        seaVisited[nx][ny] = seaVisited[curPos.x][curPos.y] + 1;
                    }
                }
            }
        }
        return min_value-1;
    }

    private static void markIsland(int idx) {
        while (!islandQ.isEmpty()) {
            Index curPos = islandQ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curPos.x + dx[d];
                int ny = curPos.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        islandQ.offer(new Index(nx, ny));
                        map[nx][ny] = idx;
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
