public class QuickSort_Study {
    public static void main(String[] args) {
        int[] array = {12, 4, 5, 0, 5, 8, 123, 5, 12, 5, 4, 2, 87, 8, 2, 1};
        quickSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left++;
            }
            while (right > start && array[right] >= array[pivot]) {
                right--;
            }

            int temp = array[right];

            if (left > right) {
                array[right] = array[pivot];
                array[pivot] = temp;
            } else {
                array[right] = array[left];
                array[left] = temp;
            }
        }

        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }
}
