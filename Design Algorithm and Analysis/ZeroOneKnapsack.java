public class ZeroOneKnapsack {
	public static int knapsack(int val[], int wt[], int W, int i, int dp[][]) {
		if (i == 0 || W == 0) // base case(2nd condition)
			return 0;

		if (dp[i][W] != -1)
			return dp[i][W];

		// according to the first condition
		if (wt[i - 1] <= W) { // inclusive
			// 1)include
			int ansOne = val[i - 1] + knapsack(val, wt, W - wt[i - 1], i - 1, dp);

			// 2)Exclude
			int ansTwo = knapsack(val, wt, W, i - 1, dp);
			dp[i][W] = Math.max(ansOne, ansTwo);
			return Math.max(ansOne, ansTwo);
		} else {
			// not inclusive
			return knapsack(val, wt, W, i - 1, dp); // according to the third condition
		}

	}

	public static void main(String[] args) {
		int val[] = { 10, 12, 28 };
		int wt[] = { 1, 2, 4 };
		int W = 6;
		int[][] dp = new int[val.length + 1][W + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		int result = knapsack(val, wt, W, val.length, dp);
		System.out.println("Maximum profit is:" + result);

	}

}
