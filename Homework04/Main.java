public class Main {
    public static void main(String[] args) {
        RedBlackTree node = new RedBlackTree();

        node.insert(10);
        node.inorder();
        System.out.println("\n");
        node.insert(5);
        node.inorder();
        System.out.println("\n");
        node.insert(15);
        node.inorder();
        System.out.println("\n");
        node.insert(3);
        node.inorder();
        System.out.println("\n");
        node.insert(7);
        node.inorder();
        System.out.println("\n");
        node.insert(13);
        node.inorder();
        System.out.println("\n");
        node.insert(20);
        node.inorder();
        System.out.println("\n");
        node.insert(14);
        node.inorder();
    }
}