public class SelectionSort_Study {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10, 5};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
