#include "lru_cache.h"
#include <iostream>
#include <cassert>

const string NOT_FOUND = "Key does not exist in cache.";
Node* head;
Node* tail;

LRUCache::LRUCache(int capacity) {
  this->capacity = capacity;
  this->cache = unordered_map<string, Node*>();
  head = nullptr;
  tail = nullptr;
}

void removeNode(Node* node) {
  if (node->previous != nullptr) {
    node->previous->next = node->next;
  } else {
    head = node->next;
  }

  if (node->next != nullptr) {
    node->next->previous = node->previous;
  } else {
    tail = node->previous;
  }
}

void setHead(Node* node) {
  if (head != nullptr) {
    node->next = head;
    head->previous = node;
    head = node;
  } else {
    head = node;
    tail = node;
  }
}

void LRUCache::put(string key, string value) {
  auto itr = cache.find(key);
  if (itr != cache.end()) {
    removeNode(itr->second);
  } else if (cache.size() >= capacity) {
    cache.erase(tail->key);
    removeNode(tail);
  }

  Node* node = new Node(key, value);
  cache.insert({key, node});
  setHead(node);
}

string LRUCache::get(string key) {
  auto itr = cache.find(key);
  if (itr != cache.end()) {
    removeNode(itr->second);
    setHead(itr->second);
    return cache.find(key)->second->value;
  }

  return NOT_FOUND;
}

int main() {
  LRUCache cache = LRUCache(3);

  cache.put("a", "A");
  cache.put("b", "B");
  cache.put("c", "C");

  // "a" has lowest priority, so it should be deleted.
  cache.put("d", "D");

  assert(cache.get("a") == NOT_FOUND);
  assert(cache.get("b") == "B");
  assert(cache.get("c") == "C");
  assert(cache.get("d") == "D");

  cache.get("c");

  // Since "c" was just retrieved, "b" and "d" should be deleted.
  cache.put("e", "E");
  cache.put("f", "F");

  assert(cache.get("a") == NOT_FOUND);
  assert(cache.get("b") == NOT_FOUND);
  assert(cache.get("c") == "C");
  assert(cache.get("d") == NOT_FOUND);
  assert(cache.get("e") == "E");
  assert(cache.get("f") == "F");
}
