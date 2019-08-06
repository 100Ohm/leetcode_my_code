package leetcode101;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        //对称
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3))
        );
        //不对称
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3),
                        null),
                new TreeNode(2,
                        new TreeNode(3),
                        new TreeNode(3))
        );
        TreeNode root2 = null;
        System.out.println(new Solution().isSymmetric(root));
        System.out.println(new Solution().isSymmetric(root1));
        System.out.println(new Solution().isSymmetric(root2));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode c1, TreeNode c2) {
        val = x;
        left = c1;
        right = c2;
    }
}
class Pair<K,V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

//自己写的非递归
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        LinkedList<Pair<TreeNode, Boolean>> s1 = new LinkedList<>();
        LinkedList<Pair<TreeNode, Boolean>> s2 = new LinkedList<>();
        s1.push(new Pair<>(root.left, false));
        s2.push(new Pair<>(root.right, false));
        TreeNode lnode, rnode;
        boolean v1, v2;

        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(s1.size() != s2.size())
                return false;
            lnode = s1.peek().getKey();
            rnode = s2.peek().getKey();
            v1 = s1.peek().getValue();
            v2 = s2.peek().getValue();
            s1.pop();
            s2.pop();
            if(lnode == null && rnode == null)
                continue;
            if((lnode == null) ^ (rnode == null))
                return false;
            if(v1 && v2) {
                if(lnode.val != rnode.val)
                    return false;
            } else {
                //先序遍历
                s1.push(new Pair<>(lnode.right, false));
                s1.push(new Pair<>(lnode.left, false));
                s1.push(new Pair<>(lnode, true));
                //先序镜像遍历
                s2.push(new Pair<>(rnode.left, false));
                s2.push(new Pair<>(rnode.right, false));
                s2.push(new Pair<>(rnode, true));
            }
        }
        return true;
    }
//    //递归
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    public boolean isMirror(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        return (t1.val == t2.val)
//                && isMirror(t1.right, t2.left)
//                && isMirror(t1.left, t2.right);
//    }
}