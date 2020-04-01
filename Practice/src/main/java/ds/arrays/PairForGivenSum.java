package ds.arrays;

import java.util.Arrays;

public class PairForGivenSum {
  public static void main(String[] args) {
    int arr[] = {4,3,5,2,1,7};
    Arrays.sort(arr);
    printArr(arr);
    System.out.println(isSunExists(arr, 9));
  }

  private static boolean isSunExists(int[] arr, int sum) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
      if (sum == (arr[i] + arr[j])) return true;
      else if (sum > (arr[i] + arr[j])) i++;
      else j--;
    }
    return false;
  }

  private static void printArr(int[] arr) {
    for (Integer i : arr) {
      System.out.print(i + ",");
    }
    System.out.println();
  }
}
