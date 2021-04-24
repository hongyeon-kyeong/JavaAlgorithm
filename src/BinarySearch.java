import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    static int N, target, answer;
    static StringTokenizer st, st2;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        array = new int[N+3];
        st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st2.nextToken());
        }
        answer = binSearch(0, N - 1);
        if (answer == N) {
            System.out.println("존재하지 않습니다.");
        } else {
            System.out.println(answer);
        }
    }

    private static int binSearch(int start, int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return N;
    }
}
