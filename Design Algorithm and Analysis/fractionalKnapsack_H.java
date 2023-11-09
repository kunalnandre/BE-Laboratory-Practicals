import java.util.*;

public class fractionalKnapsack_H {
	public static void main(String[] args) {
		int[] value = { 60, 100, 120 };
		int[] weight = { 10, 20, 30 };

		System.out.println(fractionalKnapsack(50, weight, value, weight.length));
	}

	static double fractionalKnapsack(int W, int[] weight, int[] value, int n) {
		// Your code here
		double[][] ratio = new double[n][2];
		double ans = 0, w = (double) W;

		for (int i = 0; i < n; i++) {
			ratio[i][0] = weight[i];
			ratio[i][1] = (double) value[i] / (double) weight[i];
		}

		Arrays.sort(ratio, (a, b) -> Double.compare(a[1], b[1]));
		int i = n - 1;
		while (w > 0 && i >= 0) {
			double min = Math.min(w, ratio[i][0]);
			ans += min * ratio[i][1];
			w -= min;
			i--;
		}

		return ans;
	}

}