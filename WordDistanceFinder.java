/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text.
 * Example:
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
 *   assert(finder.distance("fox","the") == 3);
 *   assert(finder.distance("quick", "fox") == 1);
 *
 * "quick" appears twice in the input. There are two possible distance values for "quick" and "fox":
 *     (3 - 1) = 2 and (4 - 3) = 1.
 * Since we have to return the shortest distance between the two words we return 1.
 */
public class WordDistanceFinder {
    public WordDistanceFinder (List<String> words) {
        MultiMap<String, Integer> wordMap = new MultiMap<>();
        for (int index = 0; index < words.size(); index++) {
        	wordMap.put(words[index], index);
        }
    }
    public int distance (String wordOne, String wordTwo) {
        LinkedList<Integer> wordOneIndices = wordMap.get(wordOne);
        LinkedList<Integer> wordTwoIndices = wordMap.get(wordTwo);

        int wordOneIndex = wordOneIndices.remove();
        int wordTwoIndex = wordTwoIndices.remove();
        int answer;

        while (!wordOneIndices.isEmpty() && !wordTwoIndices.isEmpty) {

        }
    }
}