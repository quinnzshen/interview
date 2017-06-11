public interface Triangle {
    /**
     * Find ANY three values that can be the lengths of the sides of a triangle.
     * Three segments of lengths A, B, C can form a triangle if and only if:
     *
     *      A + B > C
     *      B + C > A
     *      A + C > B
     *
     * e.g.
     *  6, 4, 5 can form a triangle
     * 10, 2, 7 can't
     *
     * @param segmentLengths the lengths of segments that might form a triangle.
     * @return ANY three values that can be the lengths of the sides of a triangle,
     *         or an empty array if there are no such values in segmentLengths.
     */
    int[] getTriangleSides(int[] segmentLengths);
}

public class Answer implements Triangle {
    @override
    int[] getTriangleSides(int[] segmentLengths) {
        Arrays.sort(segmentLengths);
        int[] answer = new int[3];

        if (segmentLengths.size() < 3) {
            return answer;
        }

        for (int i = 2; i < potentialSegments.size(); i++) {
            if (isTriangle(segmentLengths[i-2], segmentLengths[i-1], segmentLengths[i])) {
                answer[0] = segmentLengths[i-2];
                answer[1] = segmentLengths[i-1];
                answer[2] = segmentLengths[i];
                return answer;
            }
        }

        return answer;
    }

    private boolean isTriangle(int a, int b, int c) {
        return ((a + b) > c) && ((b + c) > a) && ((a + c) > b);
    }
}