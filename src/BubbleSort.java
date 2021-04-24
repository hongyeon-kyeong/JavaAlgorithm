public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {254, 2, 3, 5, 5, 12, 5, 12, 3, 58, 12, 38, 532, 1321, 213};
        int b;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    b = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = b;

                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
