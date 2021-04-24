import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dijkstra {
    static int N, M, start, a, b, dist;
    static StringTokenizer st;
    static LinkedList<Edge>[] graph;
    static int[] distance;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        distance = new int[N + 1];
        graph = new LinkedList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new LinkedList<Edge>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, dist));
        }
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstra(start);

        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra(int start) {
        q = new PriorityQueue<>();
        q.offer(new Edge(start, 0));
        distance[start] = 0;
        int cost;
        while (!q.isEmpty()) {
            Edge now = q.poll();
            if (distance[now.v] < now.weight) {
                continue;
            }
            for (Edge next : graph[now.v]) {
                cost = now.weight + next.weight;
                if (cost < distance[next.v]) {
                    distance[next.v] = cost;
                    q.offer(new Edge(next.v, cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v, weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
