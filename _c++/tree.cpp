#include <iostream>
using namespace std;

struct Node {
  Node* left;
  Node* right;
  int value;

  Node(int value, Node* left = nullptr, Node* right = nullptr) {
    this->left = left;
    this->right = right;
    this->value = value;
  }
};

Node* treeToList(Node* root) {
  if ((*root).left == nullptr && (*root).right == nullptr) {
    return root;
  }

  if ((*root).right != nullptr) {
    Node* pointer = treeToList((*root).right);

    (*pointer).left = root;
    (*root).right = pointer;
  }

  if ((*root).left != nullptr) {
    Node* pointer = (*root).left;

    while ((*pointer).right != nullptr) {
      pointer = (*pointer).right;
    }

    Node* newRoot = treeToList((*root).left);

    (*pointer).right = root;
    (*root).left = pointer;

    return newRoot;
  }

  return root;
}

int main() {
  Node a = Node(25);
  Node b = Node(30);
  Node c = Node(12, &a, &b);
  Node d = Node(36);
  Node e = Node(15, &d);
  Node root = Node(10, &c, &e);

  Node* node = treeToList(&root);
  while (node != nullptr) {
    cout << (*node).value << " ";
    node = (*node).right;
  }
  cout << endl;
}
