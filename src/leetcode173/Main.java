package leetcode173;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路写出来了，但是有的测试用例过不了
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
//        TreeNode root = new TreeNode(1);
        /**
         * ["BSTIterator","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
         * [[[3,1,4,null,2]],[null],[null],[null],[null],[null],[null],[null],[null],[null]]
         */
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        BSTIterator bstIterator = new BSTIterator(root);
        while(bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }

    static class BSTIterator {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        boolean first = true;
        TreeNode p;//当前指向的结点

        public BSTIterator(TreeNode root) {
            if(root == null) {
                p = null;
                return;
            }
            writeParent(root, null);//记录每个节点的父节点
            p = root;
            while(true) {
                if(p.left != null)
                    p = p.left;
                else
                    break;
            }
        }

        private void writeParent(TreeNode e, TreeNode parent) {
            if(e == null)
                return;
            parents.put(e, parent);
            writeParent(e.left, e);
            writeParent(e.right, e);
        }

        /** @return the next smallest number */
        public int next() {
            if(!hasNext())
                return -1;
            if(p == null)
                return -1;
            if(first) {
                first = false;
                return p.val;
            }
            TreeNode next = p;
            if(parents.get(p) == null || p.right != null) {//该结点是树的根节点，或者有右子树，那就应该获取右子树的最左一个结点
                next = p.right;
                while(true) {
                    if(next.left != null)
                        next = next.left;
                    else
                        break;
                }
            } else if(p == parents.get(p).left) {//如果是父节点的左结点，那么下一个结点就是父节点
                next = parents.get(p);
            } else if(p.right == null) {//如果没有右结点，并且有父节点，那么下一个结点就是作为其父节点左子树的祖先节点
                next = parents.get(p);
                TreeNode pp = parents.get(next);
                while(true) {
                    if(parents.get(pp) == null || pp == parents.get(pp).left) {
                        next = pp;
                        break;
                    }
                    pp = parents.get(pp);
                }
            }
            p = next;
            return next.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(p == null)
                return false;
            if(parents.get(p) == null) {
                if(p.right == null && !first)
                    return false;
                else
                    return true;
            }
            if(p == parents.get(p).left || p.right != null)
                return true;
            TreeNode parent = parents.get(p);
            while(true) {//有祖先结点是左子树
                if(parents.get(parent) == null)
                    return false;
                else if(parent == parents.get(parent).left)
                    return true;
                else {
                    parent = parents.get(parent);
                    if (parent == null)
                        return false;
                }
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */