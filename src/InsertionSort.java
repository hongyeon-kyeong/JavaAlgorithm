public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {6, 2, 3, 6, 2, 56, 5, 6, 233, 564, 5, 21, 5, 43, 2, 5, 8, 43};
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else {
                    break;
                }
            }
        }
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
