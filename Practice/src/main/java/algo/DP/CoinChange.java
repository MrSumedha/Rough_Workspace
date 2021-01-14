package algo.DP;

public class CoinChange {

    static int count(int[] coins, int sum) {
        int[] table = new int[sum + 1];
        table[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        return table[sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int sum = 20;
        System.out.println("No of ways: " + count(arr, sum));

    }
}
