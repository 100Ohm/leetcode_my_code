package tree;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ohm
 */
public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)
                )
        );
        List<String> list = new ArrayList<>();
        firstOrderTraversal(root, list);
        System.out.println(list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public static void firstOrderTraversal(TreeNode root, List<String> output){
        LinkedList<Pair> visitedList = new LinkedList<>();
        visitedList.push(new Pair<>(root, false));
        TreeNode p;
        boolean isVisited;
        while(!visitedList.isEmpty()) {
            p = (TreeNode) visitedList.peek().getKey();
            isVisited = (boolean) visitedList.peek().getValue();
            visitedList.pop();
            if(p == null)
                continue;
            if(isVisited) {
                output.add(p.toString());
            } else {
                visitedList.push(new Pair<>(p.right, false));
                visitedList.push(new Pair<>(p.left, false));
                visitedList.push(new Pair<>(p, true));
            }
        }
    }
}
