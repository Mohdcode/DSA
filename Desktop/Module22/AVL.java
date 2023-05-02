public class AVL {
     static class AVLNode {
        int value;
        int height;
        AVLNode left;
        AVLNode right;

        AVLNode(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    public static class AVLTree {
        private AVLNode root;

        public void insert(int value) {
            root = insert(root, value);
        }

        private AVLNode insert(AVLNode node, int value) {
            if (node == null) {
                return new AVLNode(value);
            }

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            } else {
                // Value already exists in the tree
                return node;
            }

            node.height = 1 + Math.max(height(node.left), height(node.right));
            //after inserting the first node checking if they are balanced or not

            int balance = getBalance(node);

            if (balance > 1 && value < node.left.value) {
                return rotateRight(node);
            }

            if (balance < -1 && value > node.right.value) {
                return rotateLeft(node);
            }

            if (balance > 1 && value > node.left.value) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }

            if (balance < -1 && value < node.right.value) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }

            return node;
        }

        private AVLNode rotateLeft(AVLNode node) {//rotate left
            AVLNode right = node.right;
            AVLNode leftOfRight = right.left;

            right.left = node;
            node.right = leftOfRight;

            node.height = 1 + Math.max(height(node.left), height(node.right));
            right.height = 1 + Math.max(height(right.left), height(right.right));

            return right;
        }

        private AVLNode rotateRight(AVLNode node) {//rotate right
            AVLNode left = node.left;
            AVLNode rightOfLeft = left.right;

            left.right = node;
            node.left = rightOfLeft;

            node.height = 1 + Math.max(height(node.left), height(node.right));
            left.height = 1 + Math.max(height(left.left), height(left.right));

            return left;
        }

        private int height(AVLNode node) {//height of the tree
            if (node == null) {
                return 0;
            }

            return node.height;
        }

        private int getBalance(AVLNode node) {
            if (node == null) {
                return 0;
            }

            return height(node.left) - height(node.right);//here we counting the 0 or -1 or 1
        }

        public void inOrderTraversal() {
            inOrderTraversal(root);// just a printing part
        }

        private void inOrderTraversal(AVLNode node) {
            //printing
            if (node != null) {
                inOrderTraversal(node.left);
                System.out.print(node.value + " ");
                inOrderTraversal(node.right);
            }
        }}

        public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            tree.insert(10);
            tree.insert(20);
            tree.insert(30);
            tree.insert(40);
            tree.insert(50);
            tree.insert(25);

            tree.inOrderTraversal();

        }


}