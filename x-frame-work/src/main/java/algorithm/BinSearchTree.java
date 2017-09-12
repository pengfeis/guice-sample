package algorithm;

public class BinSearchTree {


    public static void main(String[] args) {
        BinSearchTree tree = new BinSearchTree();
        tree.add(2);
        tree.add(5);
        tree.add(9);
        tree.add(5);
        tree.add(4);
        tree.add(8);

        System.out.println(tree);
    }


    private Node root;

    public Node add(int key) {
        Node newNode = new Node(key);
        Node curr = root;
        Node parent = null;

        if (curr == null) {
            root = newNode;
        }

        while (true) {
            parent = curr;
            if (newNode.getVal() > curr.getVal()) {
                curr = curr.getRight();
                if (curr == null) {
                    parent.right = newNode;
                    return newNode;
                }
            } else {
                curr = curr.getLeft();
                if (curr == null) {
                    parent.left = newNode;
                    return newNode;
                }
            }

        }
    }


    /**
     * 节点
     */
    static class Node {
        private int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }




}
