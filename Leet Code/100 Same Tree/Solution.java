import java.util.*;

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

public class Solution {
   public boolean isSameTree(TreeNode p, TreeNode q) {

      List<TreeNode> l = new ArrayList<>();
      List<TreeNode> r = new ArrayList<>();

      fill(p, l);
      fill(q, r);

      for (int i = 0; i < l.size() && i < r.size(); i++) {
         if (l.get(i) == null && r.get(i) == null) {
            continue;
         } else if ((l.get(i) == null && r.get(i) != null) || (l.get(i) != null && r.get(i) == null)) {
            return false;
         } else if (l.get(i).val != r.get(i).val) {
            return false;
         }
      }

      return l.size() == r.size() ? true : false;
   }

   private void fill(TreeNode curr, List<TreeNode> list) {
      if (curr == null) {
         list.add(curr);
         return;
      }

      list.add(curr);
      fill(curr.left, list);
      fill(curr.right, list);
   }
}