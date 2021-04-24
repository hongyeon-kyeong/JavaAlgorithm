package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1707 {
    static int T;
    static int V,E;
    static List<Integer>[] list;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            for (int j = 0; j < V + 1; j++) list[j] = new ArrayList<>();
            visited = new int[V + 1];

            for (int j = 0; j < E; j++) {
                StringTokenizer stj = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(stj.nextToken()), b = Integer.parseInt(stj.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            grouping();
        }
    }

    private static void grouping() {
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i < V + 1; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
            }
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int j : list[v]) {
                    if (visited[j] == 0) {
                        if (visited[v] == 1) visited[j] = 2;
                        else visited[j] = 1;
                        queue.offer(j);
                    } else if (visited[v] == visited[j]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }

}
