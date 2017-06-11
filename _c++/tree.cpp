#include <iostream>
#include <vector>
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
  if (root->left == nullptr && root->right == nullptr) {
    return root;
  }

  if (root->right != nullptr) {
    Node* pointer = treeToList(root->right);

    pointer->left = root;
    root->right = pointer;
  }

  if (root->left != nullptr) {
    Node* pointer = root->left;

    while (pointer->right != nullptr) {
      pointer = pointer->right;
    }

    Node* newRoot = treeToList(root->left);

    pointer->right = root;
    root->left = pointer;

    return newRoot;
  }

  return root;
}

vector<vector<int>> treeDepthToList(Node* root, int depth = 0, vector<vector<int>> lists = vector<vector<int>>()) {
  if (lists.size() <= depth) {
    lists.push_back(vector<int>());
  }

  lists[depth].push_back(root->value);

  if (root->left != nullptr) {
    lists = treeDepthToList(root->left, depth + 1, lists);
  }

  if (root->right != nullptr) {
    lists = treeDepthToList(root->right, depth + 1, lists);
  }

  return lists;
}

int main() {
  Node a = Node(25);
  Node b = Node(30);
  Node c = Node(12, &a, &b);
  Node f = Node(45);
  Node d = Node(36, nullptr, &f);
  Node e = Node(15, &d);
  Node root = Node(10, &c, &e);

  cout << "Depth List Tree:" << endl;
  vector<vector<int>> result = treeDepthToList(&root);
  for (auto itr = result.begin(); itr != result.end(); itr++) {
    for (int val : *itr) {
      cout << val << " ";
    }
    cout << endl;
  }

  cout << "Inorder Linked List Tree:" << endl;
  Node* node = treeToList(&root);
  while (node != nullptr) {
    cout << node->value << " ";
    node = node->right;
  }
  cout << endl;
}
