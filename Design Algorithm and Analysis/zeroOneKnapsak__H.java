public class zeroOneKnapsak__H {
	public static void main(String[] args) {
		int value[] = { 1, 2, 3 };
		int weight[] = { 4, 5, 1 };

		System.out.println(zeroOneKnapsak(4, weight, value, 3));
	}

	static int zeroOneKnapsak(int w, int[] weight, int[] value, int n) {
		if (n == 0)
			return 0;

		int include = 0, exclude = 0;

		if (w >= weight[n - 1])
			include = zeroOneKnapsak(w - weight[n - 1], weight, value, n - 1) + value[n - 1];
		exclude = zeroOneKnapsak(w, weight, value, n - 1) + 0;

		return Math.max(include, exclude);
	}
}