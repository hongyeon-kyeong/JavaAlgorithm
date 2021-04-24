package Implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
    static BufferedReader br;
    static StringTokenizer st;
    static int T, N, M;
    static int[] priority;
    static Queue<int[]> pq;
    static int answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            priority = new int[N];
            pq = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                priority[j] = Integer.parseInt(st.nextToken());
                pq.offer(new int[]{j, priority[j]});
            }
            answer = print(M);
            System.out.println(answer);
        }
    }

    private static int print(int x) {
        int count = 0;
        while (!pq.isEmpty()) {
            int[] nx = pq.poll();
            boolean able = true;
            for (int[] q : pq) {
                if (q[1] > nx[1]) {
                    able = false;
                }
            }
            //System.out.println("idx : " + nx[0] + " nx : " + nx[1] + " able : " + able);
            if (able) {
                count += 1;
                if (nx[0] == x) {
                    return count;
                }
            } else {
                pq.offer(nx);
            }
        }
        return 0;
    }
}
