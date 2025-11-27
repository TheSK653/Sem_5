// TreeNode definition for binary search tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }        
        if (root.val<val){
            root.right = insertIntoBST(root.right,val);
        }
        else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

    // Helper method to print in-order traversal
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Build a BST by inserting values
        TreeNode root = null;
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            root = sol.insertIntoBST(root, val);
        }

        System.out.print("In-order traversal of BST: ");
        sol.inOrder(root);
        System.out.println();

        // Insert a new value
        root = sol.insertIntoBST(root, 65);
        System.out.print("After inserting 65: ");
        sol.inOrder(root);
        System.out.println();
    }
}