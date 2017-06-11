/**
* "leaf balance": every node has the same number of leaves on each side, within +/- 1
*
*    -1  
*   / \
*  /3\ ^\
* /2\ 1 /2\
*    
**/

public int isLeafBalanced(TreeNode root) {
  int leftLeaves;
  int rightLeaves;
  
  if (root.left == null && root.right == null) {
    return 1;
  } else if (root.left == null) {
     leftLeaves = 0;
     rightLeaves = isLeafBalanced(root.right());
  } else if (root.right == null) {
     rightLeaves = 0;
     leftLeaves = isLeafBalanced(root.left());
  } else {
     leftLeaves = isLeafBalanced(root.left());
     rightLeaves = isLeafBalanced(root.right());
  }

  if (leftLeaves == -1 || rightLeaves == -1) {
    return -1;
  } else {
    if (Math.abs(leftLeaves - rightLeaves) <= 1) {
      return leftLeaves + rightLeaves;
    } else {
      return -1;
    }
  }
}


