import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static int[][] map;
    static int N, M, start, end;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int m=0; m < M; m++) {
            st = new StringTokenizer(br.readLine()," ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

        System.out.println("그래프 BFS 정렬 순서 : ");
        bfs(1);
    }

    private static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(point);
        visited[point] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x+" ");

            for (int i=0; i<=N; i++) {
                if(map[x][i] ==1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
