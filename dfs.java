public List<GridPosition> dfs(GridPosition startingPosition) {
	Stack<GridPosition> stack = new Stack();
	Map<GridPosition, GridPosition> parentMap = new HashMap<>();

	GridPosition currentPosition = startingPosition;	

	stack.push(currentPosition);

	while (!stack.empty()) {
		currentPosition = stack.pop();

		if (currentPosition.visited() == false) {
			if (currentPosition.isEnd()) {
				List<GridPosition> trail = new ArrayList<>();

				while (currentPosition != startingPosition) {
					trail.add(currentPosition);
					currentPosition = currentPosition.get(currentPosition);
				}

				return trail;
			}

			for (GridPosition newPosition : currentPosition.getValidAdjacentPositions()) {
				stack.push(newPosition);
				parentMap.put(newPosition, currentPosition);
			}
		}
	}
}