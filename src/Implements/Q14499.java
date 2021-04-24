package Implements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, X, Y, K;
    static int[][] map;
    static int[] command;
    static int dx[] = {0, 0, 0, -1, 1};
    static int dy[] = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        command = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            int dir = command[i];
            int nx = X + dx[dir];
            int ny = Y + dy[dir];

            if (!isValid(nx, ny)) continue;

            dice.turn(dir);
            if (map[nx][ny] == 0) map[nx][ny] = dice.getNum(7 - dice.up);
            else {
                dice.setNum(7 - dice.up, map[nx][ny]);
                map[nx][ny] = 0;
            }
            System.out.println(dice.getNum(dice.up));

            X = nx;
            Y = ny;
        }
    }

    private static boolean isValid(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            return true;
        }
        return false;
    }
}

class Dice {
    int[] nums;
    int up, right, front;

    Dice() {
        nums = new int[6];
        up = 1;
        right = 3;
        front = 2;
    }

    void turn(int dir) {
        int temp = up;
        switch (dir) {
            case 1 :
                up =  7 - right;
                right = temp;
                break;
            case 2:
                up = right;
                right = 7 - temp;
                break;
            case 3:
                up = front;
                front = 7 - temp;
                break;
            case 4:
                up = 7 - front;
                front = temp;
                break;
        }
    }

    void setNum(int num, int value) {
        nums[num - 1] = value;
    }

    int getNum(int num) {
        return nums[num - 1];
    }
}
