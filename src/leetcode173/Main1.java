package leetcode173;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ohm
 */
public class Main1 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
//        TreeNode root = new TreeNode(1);
        /**
         * ["BSTIterator","hasNext","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
         * [[[3,1,4,null,2]],[null],[null],[null],[null],[null],[null],[null],[null],[null]]
         */
        Main.TreeNode root = new Main.TreeNode(3, new Main.TreeNode(1, null, new Main.TreeNode(2)), new Main.TreeNode(4));
        Main.BSTIterator bstIterator = new Main.BSTIterator(root);
        while(bstIterator.hasNext()) {
            System.out.println(bstIterator.next());
        }
    }
}

class TreeNode {
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

class Pair<K, V> {
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

class BSTIterator {
    LinkedList<Pair<TreeNode, Boolean>> s = new LinkedList<>();
    TreeNode p;

    public BSTIterator(TreeNode root) {
        if(root == null) {
            return;
        }
        s.push(new Pair<>(root, false));
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p;
        boolean isVisited;
        while(!s.isEmpty()) {
            p = s.peek().getKey();
            isVisited = s.peek().getValue();
            s.pop();
            if(isVisited) {
                return p.val;
            } else {
                if(p.right != null)
                    s.push(new Pair<>(p.right, false));
                s.push(new Pair<>(p, true));
                if(p.left != null)
                    s.push(new Pair<>(p.left, false));
            }
        }
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
