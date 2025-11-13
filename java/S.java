import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S{
    class Node {
        int val;
        Node left, right;
    }
    private Node root;
    public S() {
        Create_Tree();
    }
    private void Create_Tree() {
        Scanner sc = new Scanner(System.in);
        Queue <Node> queue = new LinkedList<>();
        Node nn = new Node();
        nn.val = sc.nextInt();
        root = nn;
        // queue.add(root);
        queue.add(nn);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                Node leftNode = new Node();
                leftNode.val = leftVal;
                current.left = leftNode;
                queue.add(leftNode);
            }
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                Node rightNode = new Node();
                rightNode.val = rightVal;
                current.right = rightNode;
                queue.add(rightNode);
            }
        }
    }

    public static void main(String[] args) {
        // Example: Print Hello World
        System.out.println("Hello World");
        // Add your logic here
    }
}