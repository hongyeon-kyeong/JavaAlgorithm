public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 5, 13, 545, 89, 521, 2, 5, 1, 5, 5, 8, 2, 12321, 8, 25};
        quicksort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void quicksort(int[] array, int start, int end) {
        if (start >= end) { // 원소가 1개인 경우 종료.
            return;
        }

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left += 1;
            }
            while (right > start && array[right] >= array[pivot]) {
                right -= 1;
            }

            int temp;
            if (left > right) {
                temp = array[right];
                array[right] = array[pivot];
                array[pivot] = temp;
            } else {
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        quicksort(array, start, right-1);
        quicksort(array, right+1, end);
    }
}
