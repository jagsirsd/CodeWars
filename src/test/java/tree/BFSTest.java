package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BFSTest {

    @Test
    void bfsForACreatedTreeHappyCase() {
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
        Assertions.assertArrayEquals(bfsResult.toArray(), new Integer[]{5,3,7,2,4,8});
    }

    @Test
    void bfsForACreatedTreeHappyCaseTreeFromOutside() {
        // Constructing a simple BST:
        //        5
        //       / \
        //      3   7
        //     / \   \
        //    2   4   8
        BFS bfs = new BFS();
        Tree<Integer> root = new Tree<>(5);
        root.left = new Tree<>(3);
        root.left.left = new Tree<>(2);
        root.left.right = new Tree<>(4);
        root.right = new Tree<>(7);
        root.right.right = new Tree<>(10);

        bfs.setRoot(root);

        // Perform BFS on the BST
        List<Integer> bfsResult = bfs.bfs();
        Assertions.assertIterableEquals(bfsResult, List.of(5,3,7,2,4,10));
    }


    @Test
    void bfsForNullTree() {

        BFS bfs = new BFS();
        Tree<Integer> root = null;
        bfs.setRoot(root);
        // Perform BFS on the BST
        List<Integer> bfsResult = bfs.bfs();
        Assertions.assertIterableEquals(bfsResult, List.of());
    }

    @Test
    void bfsForOnlyOneNode() {
        // Constructing a simple BST:
        //        5
        //       / \
        //      3   7
        //     / \   \
        //    2   4   8
        BFS bfs = new BFS(0);
        //Tree<Integer> root = bfs.getRoot();
        // Perform BFS on the BST
        List<Integer> bfsResult = bfs.bfs();
        Assertions.assertIterableEquals(bfsResult, List.of(0));
    }
}