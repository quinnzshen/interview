#ifndef WORD_DISTANCE_H
#define WORD_DISTANCE_H

#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class WordDistance {
  private:
    unordered_map<string, vector<int>> wordMap;
  public:
    WordDistance(vector<string> words);
    int distance(string wordOne, string wordTwo);
};

#endif
