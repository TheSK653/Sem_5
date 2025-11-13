class Solution {
    int c=0;
    public int minCameraCover(TreeNode root) {
        int x=cameras(root);
        if(x==-1)c++;
        return c;
    }
    public int cameras(TreeNode root){
        if(root==null){
            return 0;
        }
        int  left=cameras(root.left);
        int  right=cameras(root.right);
        if(left==-1 || right==-1){
            c++;
            return 1;
        }
        if(left==1 || right==1){
            return 0;
        }
        return -1;
    }
}