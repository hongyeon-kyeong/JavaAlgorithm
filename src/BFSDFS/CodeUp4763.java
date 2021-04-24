package BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class CodeUp4763 {
    static int N, rivalTot;
    static List<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            rivalTot = Integer.parseInt(st.nextToken());

            for (int j = 0; j < rivalTot; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        grouping();
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (visited[j] == i) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    private static void grouping() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int parent = queue.poll();
                int[] rivalCnt = new int[3];
                for (int child : list[parent]) {
                    int grpChild = visited[child];
                    int grpParent = visited[parent];
                    // 자식 노드를 처음 방문하면 부모와 반대 그룹으로 넣어준다.
                    if (grpChild == 0) {
                        if (grpParent == 1) visited[child] = 2;
                        else visited[child] = 1;
                        queue.offer(child);
                    // 자식 노드가 한번 방문되었으면
                    } else {
                        // 부모와 같은 그룹인지
                        if (grpChild == grpParent) {
                            // cnt가 1 이상이면 반대그룹으로 이동시킨다.
                            if (rivalCnt[grpParent] > 0) {
                                if (grpParent == 1) visited[child] = 2;
                                else visited[child] = 1;
                            // 아니면 부모와 반대그룹에 넣고 cnt를 하나 올린다.
                            } else {
                                rivalCnt[grpParent] += 1;
                            }
                        }
                    }
                }
            }
        }
    }
}

