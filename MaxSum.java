public int maxSum(List<Integer> values) {
	int maxSum = Integer.MIN_VALUE;
	int currentSum = 0;

	for (Integer value : values) {
		currentSum = (currentSum < 0) ? 0 : currentSum;
		currentSum += value;

		maxSum = Math.max(currentSum, maxSum);
	}

	return maxSum;
}

public int maxProduct(List<Integer> values) {
	int maxProduct = Integer.MIN_VALUE;
	int currentPositiveProduct = 1;
	int currentProduct = 1;

	for (Integer value : values) {
		if (value > 0) {
			currentPositiveProduct = 1;
		}

		currentProduct = (currentProduct == 0) ? 1 : currentProdct;
		currentProduct *= value;

		maxProduct = Math.max(currentProdct, maxProduct);
	}

	return maxProduct;
}

// (1, 2, -4, 1, 3, 0, 3, -1) 

maxProduct = 2;
currentProduct = 0;

