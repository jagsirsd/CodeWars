package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Tree<T>{
    final T val;
    Tree<T> left;
    Tree<T> right;

    Tree(T val) {
        this.val = val;
    }
}
public class BFS {
    Tree<Integer> getRoot() {
        return root;
    }

    void setRoot(Tree<Integer> root) {
        this.root = root;
    }

    Tree<Integer> root;

    public BFS(Integer valueAtRoot) {
        root = new Tree<>(valueAtRoot);
    }
    public BFS() {
    }

    public List<Integer> bfs() {
        List<Integer> result = new ArrayList<>();

        if(root == null ) {// Return Empty List
            return result;
        }

        Deque<Tree<Integer>> queue = new LinkedList<>();
        queue.offer(root); //Same as put

        while (!queue.isEmpty()) {
            Tree<Integer> current = queue.poll(); //same as get
            result.add(current.val);
            if(current.left != null) {
                queue.offer(current.left);
            }
            if(current.right != null) {
                queue.offer(current.right);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Constructing a simple BST:
        //        5
        //       / \
        //      3   7
        //     / \   \
        //    2   4   8
        BFS bfs = new BFS(5);
        Tree<Integer> root = bfs.getRoot();
        //Tree<Integer> root = new Tree<>(5);
        root.left = new Tree<>(3);
        root.left.left = new Tree<>(2);
        root.left.right = new Tree<>(4);
        root.right = new Tree<>(7);
        root.right.right = new Tree<>(8);

        // Perform BFS on the BST
        List<Integer> bfsResult = bfs.bfs();
        System.out.println("BFS Order: " + bfsResult);
    }
}
