public class RedBlackTree <V extends Comparable<V>> {
    private Node root;

   class Node {
        Node left, right;
        V value;
        Color color;
        Node(V value) {
            this.value = value;
            left = null;
            right = null;
            color = Color.RED;
        }
        @Override
        public String toString() {
            return "Node{" + " value=" + value + ", color=" + color +
                    ",left=" + left + ", right=" + right +'}';
        }
    }
    private Node leftSwap (Node node){
    Node child = node.right;
    Node leftChild = child.left;
    child.left = node;
    node.right = leftChild;
    return child;
}
    private Node rightSwap (Node node){
    Node child = node.left;
    Node rightChild = child.right;
    child.right = node;
    node.left = rightChild;
    return child;
}
    private boolean isRed (Node node){
    return node != null && node.color.equals(Color.RED);
}
    private void swapColors (Node node1, Node node2){
    Color temp = node1.color;
    node1.color = node2.color;
    node2.color = temp;
}
    public boolean insert (V value){
    Node node;
    if (root != null) {
        node = insert(root, value);
        if (node == null) {
            return false;
        }
    } else {
        node = new Node(value);
    }
    root = node;
    root.color = Color.BLACK;
    return true;
}
    private Node insert (Node node, V value){
    if (node == null) {
        return new Node(value);
    }
    if (node.value.compareTo(value) > 0) {
        node.left = insert(node.left, value);
    } else if (node.value.compareTo(value) < 0) {
        node.right = insert(node.right, value);
    } else
        return null;
    return balance(node);
}
    private Node balance (Node node){
    if (isRed(node.right) && !isRed(node.left)) {
        node = leftSwap(node);
        swapColors(node, node.left);
    }
    if (isRed(node.left) && isRed(node.left.left)) {
        node = rightSwap(node);
        swapColors(node, node.right);
    }
    if (isRed(node.left) && isRed(node.right)) {
        node.color = Color.RED;
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }
    return node;
}
    public void inorder () {
    inorder(root);
}
    private void inorder (Node node){
    if (node != null) {
        inorder(node.left);
        System.out.print("|" + node.value + " " + node.color + "|");
        inorder(node.right);
        }
    }
    private enum Color {
        RED, BLACK
    }
}
