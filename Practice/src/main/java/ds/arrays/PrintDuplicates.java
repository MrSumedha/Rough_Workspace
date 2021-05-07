package ds.arrays;

public class PrintDuplicates {

    private static void printArr(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0) {
                arr[j] = -arr[j];
            } else {
                System.out.print(j + " ");
            }
        }
        printArr(arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 3, 3, 4, 5, 1};
        printDuplicates(arr);
    }
}
