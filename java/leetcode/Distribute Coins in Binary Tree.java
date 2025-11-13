class Solution {
    int ans=0;
    public int distributeCoins(TreeNode root) {
        minmove(root);
        return ans;
    }
    public int minmove(TreeNode root){
        if(root==null) return 0;

        int right =minmove(root.right);
        int left = minmove(root.left);

        ans+=Math.abs(right)+Math.abs(left);

        return root.val+left+right-1;
    }
}