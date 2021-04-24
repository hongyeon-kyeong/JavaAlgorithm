import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS_Study {
    static int N, M, start, end;
    static LinkedList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        System.out.println("그래프 DFS 방문순서");
        dfs(1);
    }

    private static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

/*
        for (int i = 0; i < adjList[node].size(); i++) {
            dfs(adjList[node].get(i));

        }
*/
        Iterator<Integer> iter = adjList[node].listIterator();
        while (iter.hasNext()) {
            int v = iter.next();
            if (visited[v] == false) {
                dfs(v);
            }
        }
    }
}
