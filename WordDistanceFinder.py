class WordDistanceFinder:
    """
    This class will be given a list of words and will provide a method that
    takes two words and returns the shortest distance (in words) between 
    those two words in the provided text.

    Example:
        finder = WordDistanceFinder(["the", "quick", "brown", "fox", "quick"])
        finder.distance("fox", "the") -> 3
        finder.distance("quick", "fox") -> 1
    """

    def __init__(self, words):
        pass

    def distance(self, wordOne, wordTwo):
        pass

    ## MY SOLUTION
    # def __init__(self, words):
    #     self.word_map = dict()
    #     for index in xrange(len(words)):
    #         word = words[index]
    #         if word in self.word_map:
    #             self.word_map[word] += [index]
    #         else:
    #             self.word_map[word] = [index]
         
    # def distance(self, wordOne, wordTwo):
    #     min_distance = -1
    #     if not(wordOne in self.word_map.keys() and wordTwo in self.word_map.keys()):
    #         return min_distance
    #     wordOne_indices = self.word_map[wordOne]
    #     wordTwo_indices = self.word_map[wordTwo]

    #     for wordOne_index in wordOne_indices:
    #         for wordTwo_index in wordTwo_indices:
    #             distance = abs(wordTwo_index - wordOne_index)
    #             if (min_distance == -1) or (distance < min_distance):
    #                 min_distance = distance

    #     return min_distance
