package ds.arrays;

public class BinarySearch {

  private static int binSearch(int[] arr, int lower, int upper, int val) {
    int mid = (lower + upper) / 2;
    if (mid < lower || mid > upper) {
      return -1;
    }
    if (arr[mid] == val) {
      return mid;
    }
    if (arr[mid] > val) {
      return binSearch(arr, lower, mid, val);
    } else {
      return binSearch(arr, mid + 1, upper, val);
    }
  }

  public static void main(String[] args) {
    int arr[] = {1};
    System.out.println(binSearch(arr, 0, arr.length - 1, 3));
  }
}
