package BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q13549_dijkstra {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] distance = new int[100001];
    static PriorityQueue<Point> locaQ = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 100001; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        find();
        System.out.println(distance[K]);
    }

    private static void find() {
        locaQ.offer(new Point(N, 0));
        distance[N] = 0;
        while (!locaQ.isEmpty()) {
            Point curL = locaQ.poll();

            int nx, cost;

            nx = curL.x + 1;
            cost = curL.y + 1;
            if (nx <= 100000 && cost < distance[nx]) {
                distance[nx] = cost;
                locaQ.offer(new Point(nx, cost));
            }

            nx = curL.x - 1;
            cost = curL.y + 1;
            if (0 <= nx && cost < distance[nx]) {
                distance[nx] = cost;
                locaQ.offer(new Point(nx, cost));
            }

            nx = curL.x * 2;
            cost = curL.y;
            if (nx <= 100000 && cost < distance[nx]) {
                distance[nx] = cost;
                locaQ.offer(new Point(nx, cost));
            }

        }
    }
    static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (this.y > that.y) {
                return 1;
            } else if (this.y < that.y) {
                return -1;
            }
            return 0;
        }
    }
}
