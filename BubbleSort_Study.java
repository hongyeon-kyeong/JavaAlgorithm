public class BubbleSort_Study {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10, 7};
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
