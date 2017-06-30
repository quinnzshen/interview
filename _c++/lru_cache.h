#ifndef LRU_CACHE_H
#define LRU_CACHE_H

#include <string>
#include <unordered_map>
using namespace std;

struct Node {
  string key;
  string value;
  Node* next;
  Node* previous;

  Node(string key, string value) {
    this->key = key;
    this->value = value;
    this->next = nullptr;
    this->previous = nullptr;
  }

  void removeNode(Node* node);
  void setHead(Node* node);
};

class LRUCache {
  private:
    unordered_map<string, Node*> cache;
    int capacity;
  public:
    LRUCache(int capacity);
    void put(string key, string value);
    string get(string key);
};

#endif
