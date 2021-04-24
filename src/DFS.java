import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS {
    static int N, M, start, end;
    static int[][] map;
    static boolean[] visited;
    static StringTokenizer st;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = 1;
            map[end][start] = 1;
        }

        System.out.println("그래프 DFS 방문 순서");
        dfs(1);
    }

    private static void dfs(int point) {
        Stack<Integer> stack = new Stack<>();
        stack.push(point);
        visited[point] = true;
        System.out.print(point + " ");

        while (!stack.isEmpty()) {
            for (int i = 0; i <= N; i++) {
                if (map[point][i] == 1 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                    dfs(i);
                }
            }
            stack.pop();
        }
    }
}
