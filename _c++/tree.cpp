#include <iostream>
#include <climits>
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

bool isBinarySearchTree(Node* root, int lowerBound = INT_MIN, int upperBound = INT_MAX) {
  if (root->value > upperBound || root->value < lowerBound) {
    return false;
  }

  if (root->left != nullptr) {
    if (!isBinarySearchTree(root->left, lowerBound, root->value)) {
      return false;
    }
  }

  if (root->right != nullptr) {
    if (!isBinarySearchTree(root->right, root->value, upperBound)) {
      return false;
    }
  }

  return true;
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
  Node* root = new Node(10);
  root->left = new Node(12);
  root->right = new Node(15);
  root->left->left = new Node(25);
  root->left->right = new Node(30);
  root->right->left = new Node(36);

  cout << "Depth List Tree:" << endl;
  vector<vector<int>> result = treeDepthToList(root);
  for (auto itr = result.begin(); itr != result.end(); itr++) {
    for (int val : *itr) {
      cout << val << " ";
    }
    cout << endl;
  }

  cout << "Inorder Linked List Tree:" << endl;
  Node* node = treeToList(root);
  while (node != nullptr) {
    cout << node->value << " ";
    node = node->right;
  }
  cout << endl;

  root = new Node(4);
  root->left = new Node(1);
  root->right = new Node(10);
  root->right->left = new Node(5);
  root->right->right = new Node(16);

  cout << "isBinarySearchTree():" << endl;
  cout << boolalpha << isBinarySearchTree(root) << endl;
}
