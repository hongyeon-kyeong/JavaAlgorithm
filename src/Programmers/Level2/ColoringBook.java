package src.Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    //static int m;
    //static int n;
    //static boolean[][] visited = new boolean[m][n];
    //static int[][] picture;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {

        //picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        //int[] solution = solution(m, n, picture);
        //System.out.println(solution[0]);
        //System.out.println(solution[1]);
    }

    private static int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && picture[i][j] > 0) {
                    //System.out.println("i = " + i);
                    //System.out.println("j = " + j);
                    numberOfArea++;
                    int area = bfs(new Index(i, j), m, n, picture, visited);
                    if (area > maxSizeOfOneArea) {
                        maxSizeOfOneArea = area;
                    }
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int bfs(Index pos, int m, int n, int[][] picture, boolean[][] visited) {
        Queue<Index> queue = new LinkedList<>();
        queue.add(pos);
        int area = 1;
        visited[pos.x][pos.y] = true;

        while (!queue.isEmpty()) {
            Index curPos = queue.poll();
            int color = picture[curPos.x][curPos.y];

            for (int d = 0; d < 4; d++) {
                int nx = curPos.x + dx[d];
                int ny = curPos.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (visited[nx][ny] == false && picture[nx][ny] == color) {
                        //System.out.println("nx = " + nx);
                        //System.out.println("ny = " + ny);

                        //System.out.println("picture = " + picture[nx][ny]);
                        queue.add(new Index(nx, ny));
                        visited[nx][ny] = true;
                        area++;
                    }
                }
            }
        }
        return area;
    }

    static class Index {
        int x;
        int y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
