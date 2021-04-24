package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {
    static BufferedReader br;
    static StringTokenizer st;
    static int F, S, G, U, D;
    static int[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];
        answer = useElevator();
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer-1);
        }
    }

    private static int useElevator() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 1;

        while (!queue.isEmpty()) {
            int curFloor = queue.poll();

            if (curFloor == G) {
                return visited[curFloor];
            }

            if (curFloor + U <= F && visited[curFloor + U] == 0) {
                queue.offer(curFloor + U);
                visited[curFloor + U] = visited[curFloor] + 1;
            }

            if (curFloor - D > 0 && visited[curFloor - D] == 0) {
                queue.offer(curFloor - D);
                visited[curFloor - D] = visited[curFloor] + 1;
            }
        }
        return -1;
    }
}
