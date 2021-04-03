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
    static Hedgehog hedgehog;
    static Water water;
    static int target_x, target_y;
    static int answer;
    static String ml;
    static Queue<Water> waterQ = new LinkedList<Water>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visitedH = new boolean[R][C];
        visitedW = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            ml = br.readLine();
            for (int j = 0; j < C; j++) {

                graph[i][j] = ml.charAt(j);

                if (graph[i][j] == 'S') {
                    hedgehog = new Hedgehog(i, j, 0);
                    visitedH[i][j] = true;
                } else if (graph[i][j] == '*') {
                    water = new Water(i, j, 0);
                    waterQ.offer(water);
                    visitedW[i][j] = true;
                } else if (graph[i][j] == 'D') {
                    target_x = i;
                    target_y = j;
                }
            }
        }
        answer = bfs(hedgehog, water);
        if (answer == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    public static void move(int timecnt) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nx, ny;
        Water waterP;
        Water waterN;

        while (!waterQ.isEmpty()) {
            waterP = waterQ.poll();
            //System.out.println("waterP.x = " + waterP.x + " waterP.y : " + waterP.y + " waterP.time : " + waterP.time + " timecnt : " + timecnt);
            if (waterP.time > timecnt) {
                waterQ.offer(waterP);
                break;
            }
            for (int d = 0; d < 4; d++) {
                nx = waterP.x + dx[d];
                ny = waterP.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if ( graph[nx][ny] != 'X' && graph[nx][ny] != 'D' && !visitedW[nx][ny]) {
                        graph[nx][ny] = '*';
                        waterN = new Water(nx, ny, waterP.time + 1);
                        waterQ.offer(waterN);
                        visitedW[nx][ny] = true;
                    }
                }
            }
        }
    }

    static class Water {
        int x, y, time;

        public Water(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }

    static class Hedgehog {
        int x, y, time;

        public Hedgehog(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    private static int bfs(Hedgehog hedgehog, Water water) {

        Queue<Hedgehog> q = new LinkedList<>();

        int timecnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nx, ny;
        q.offer(hedgehog);
        visitedH[hedgehog.x][hedgehog.y] = true;
        move(0);

        while (!q.isEmpty()) {
            Hedgehog hh = q.poll();
            //System.out.println("hh.x = " + hh.x + " hh.y : " + hh.y + " hh.time : " + hh.time + " timecnt : " + timecnt);
            if (hh.time > timecnt) {
                q.offer(hh);
                move(hh.time);
                timecnt += 1;
            }
            if ((hh.x == target_x) && (hh.y == target_y)) {
                return timecnt;
            }

            for (int i = 0; i < 4; i++) {
                nx = hh.x + dx[i];
                ny = hh.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (graph[nx][ny] == '.' || graph[nx][ny] == 'D') {
                        if (!visitedH[nx][ny]) {
                            Hedgehog nexthh = new Hedgehog(nx, ny, hh.time + 1);
                            q.offer(nexthh);
                            visitedH[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
