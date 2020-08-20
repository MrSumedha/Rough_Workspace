package ds.arrays;

public class SortedArrayNumFreq {

    static int count(int arr[], int x) {
        int i, j;
        i = firstOccurrence(arr, 0, arr.length - 1, x);
        if (i == -1) return i;
        j = lastOccurrence(arr, i, arr.length - 1, x);
        return j - i + 1;
    }

    static int firstOccurrence(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (arr[mid] == x && (mid == 0 || x > arr[mid - 1]))
                return mid;
            else if (x > arr[mid])
                return firstOccurrence(arr, (mid + 1), high, x);
            else
                return firstOccurrence(arr, low, (mid - 1), x);
        }
        return -1;
    }

    static int lastOccurrence(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if (arr[mid] == x && (mid == arr.length - 1 || x < arr[mid + 1]))
                return mid;
            else if (x < arr[mid])
                return lastOccurrence(arr, low, (mid - 1), x);
            else
                return lastOccurrence(arr, (mid + 1), high, x);
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3, 5, 5, 6};
        int c = count(arr, 5);
        System.out.println("Occurs " + c + " times");
    }
}


