package ys.datastructure.tree;

public class BinaryTree{

    private static class Node<V>{
        private V data;
        private Node<V> left;
        private Node<V> right;

        public Node(V data) {
            this.data = data;
        }

        V getData(){
            return data;
        }
    }

    private Node root;
    private int size;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.getData());
            inorder(node.right);
        }

    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.right);
            postorder(node.left);
            System.out.println(node.getData());
        }
    }
}
