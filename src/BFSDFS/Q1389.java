package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1389 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] list;
    static int[] kbNum;
    static int min_value = 100;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();
        kbNum = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                kbNum[i] += networking(i, j);
            }
            //System.out.println("kbNum[" + i + "] " + kbNum[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (kbNum[i] < min_value) {
                min_value = kbNum[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }

    private static int networking(int start, int end) {
        int[] visited = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == end) {
                //System.out.println("start  = " + start + " end = " + end + " depth = " + visited[v]);
                return visited[v];
            }
            for (int u : list[v]) {
                if (visited[u] == 0) {
                    queue.offer(u);
                    visited[u] = visited[v] + 1;
                }
            }
        }
        return 0;
    }

}
