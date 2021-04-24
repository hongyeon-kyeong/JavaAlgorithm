package BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13549 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] times = new int[100001];
    static Queue<Point> posQ = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        find();
        System.out.println(answer);
    }

    private static void find() {
        posQ.offer(new Point(N,0));
        //visited[N] = true;

        while (!posQ.isEmpty()) {
            Point curP = posQ.poll();
            visited[curP.x] = true;

            if (curP.x == K) {
                answer = Math.min(curP.y, answer);
            }

            int nextP;

            nextP = curP.x * 2;
            if (isVisited(nextP)) {
                posQ.offer(new Point(nextP, curP.y));
                //visited[nextP] = true;
                //times[nextP] = times[curP];
            }

            nextP = curP.x + 1;
            if (isVisited(nextP)) {
                posQ.offer(new Point(nextP, curP.y + 1));
                //visited[nextP] = true;
                //times[nextP] = times[curP] + 1;
            }

            nextP = curP.x - 1;
            if (isVisited(nextP)) {
                posQ.offer(new Point(nextP, curP.y + 1));
                //visited[nextP] = true;
                //times[nextP] = times[curP] + 1;
            }

        }
    }

    private static boolean isVisited(int nextP) {
        if (0 <= nextP && nextP <= 100000 && !visited[nextP]) {
            return true;
        }
        return false;
    }
}
