package algo.DP;

public class CoinChange {
	
	static int count(int S[], int m, int n) {
		if (n == 0) {
			System.out.println("Returning 1 at m = " + m);
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (m <= 0 && n >= 1) {
			return 0;
		}
		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println("No of ways: " + count(arr, m, 5));

	}
}
