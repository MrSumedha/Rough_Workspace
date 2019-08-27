package algo.sorting;

public class MergeSort {

	public static int[] merge(int[] a, int[] b) {
		if (b == null)
			return a;
		if (a == null)
			return b;
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (i < a.length) {
			c[k++] = a[i++];
		}
		while (j < b.length) {
			c[k++] = b[j++];
		}
		return c;
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		int[] a = null;
		int[] b = null;
		if (low < high) {
			int mid = (low + high) >> 1;
			a = mergeSort(arr, low, mid);
			b = mergeSort(arr, mid + 1, high);
			return merge(a, b);
		} else {
			int[] tarr = { arr[low] };
			return tarr;
		}
	}

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 6, 1, 2, 9, 8 };
		int[] c = mergeSort(a, 0, a.length - 1);
		printArr(c);
	}

	public static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
