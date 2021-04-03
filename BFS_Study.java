import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_Study {
    static int N, M, start, end;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }
        System.out.println("그래프 BFS 방문 순서");
        bfs(1);
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList();
        q.offer(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + " ");

            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 1 && visited[j] == false) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
