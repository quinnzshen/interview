#include "word_distance.h"
#include <algorithm>
#include <iostream>
#include <cassert>
using namespace std;

WordDistance::WordDistance(vector<string> words) {
  for (int index = 0; index < words.size(); index++) {
    string word = words[index];
    auto itr = wordMap.find(word);
    if (itr != wordMap.end()) {
      itr->second.push_back(index);
    } else {
      vector<int> indices;
      indices.push_back(index);
      wordMap.insert({word, indices});
    }
  }
}

int WordDistance::distance(string wordOne, string wordTwo) {
  auto first = wordMap.find(wordOne);
  auto second = wordMap.find(wordTwo);

  int result = -1;

  if (first == wordMap.end() || second == wordMap.end()) {
    return result;
  }

  vector<int> wordOneIndices = first->second;
  vector<int> wordTwoIndices = second->second;

  auto itr1 = wordOneIndices.begin();
  auto itr2 = wordTwoIndices.begin();

  while (itr1 != (wordOneIndices.end() + 1) && itr2 != (wordTwoIndices.end() + 1)) {
    int dist = fabs(*itr1 - *itr2);
    if (result == -1 || dist < result) {
      result = dist;
    }

    if (*itr1 > *itr2) {
      itr2++;
    } else {
      itr1++;
    }
  }

  return result;
}

int main() {
  vector<string> words;
  words.push_back("the");
  words.push_back("quick");
  words.push_back("brown");
  words.push_back("fox");
  words.push_back("quick");

  WordDistance wordDistance = WordDistance(words);

  assert(wordDistance.distance("quick", "fox") == 1);
  assert(wordDistance.distance("fox", "the") == 3);
  assert(wordDistance.distance("brown", "cayote") == -1);
}
