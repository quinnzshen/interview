public interface TwoSum {
    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);
 
    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}

public class Answer implements TwoSum {
    private Set<Integer> twoSumValues = new HashSet<>();
    private Set<Integer> values = new HashSet<>();

    @override
    void store(int input) {
        for (value : values) {
            twoSumValues.add(input + value);
        }

        values.add(input);
    }

    @override
    boolean test(int val) {
        return twoSumValues.contains(val);
    }
}

public class Answer2 implements TwoSum {
    private Set<Integer> values = new HashSet<>();

    @override
    void store(int input) {
        values.add(input);
    }

    @override
    boolean test(int val) {
        for (value : values) {
            if (values.contains(val - value)) {
                return true;
            }
        }

        return false;
    }
}

values = {1, -2, 3, 6};
twoSumValues = {-1, 4, 1, 7, 4, 9};
threeSumValues = {2, 5, 10, 7}