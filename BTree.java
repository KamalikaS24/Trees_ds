import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BTree {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter root node value: ");
            int rootVal = sc.nextInt();
            BinaryTree bt = new BinaryTree();
            bt.NodeVal(rootVal);

            System.out.print("Enter left of root: ");
            int leftVal = sc.nextInt();
            bt.insertLeft(bt.root, leftVal);

            System.out.print("Enter right of root: ");
            int rightVal = sc.nextInt();
            bt.insertRight(bt.root, rightVal);

            System.out.print("Enter left of " + leftVal + ": ");
            int leftLeft = sc.nextInt();
            bt.insertLeft(bt.root.left, leftLeft);

            System.out.print("Enter right of " + rightVal + ": ");
            int rightRight = sc.nextInt();
            bt.insertRight(bt.root.right, rightRight);

            System.out.println();
            System.out.print("PreOrder: ");
            bt.PreOrder(bt.root);
            System.out.print("");

            System.out.println();
            System.out.print("InOrder: ");
            bt.InOrder(bt.root);
            System.out.print("");

            System.out.println();
            System.out.print("PostOrder: ");
            bt.PostOrder(bt.root);
            System.out.println("");

            System.out.println("Counted Nodes :"+bt.CountNode(bt.root));
            System.out.println(" ");

            System.out.println("Height of the Nodes: "+bt.Height(bt.root));
            System.out.println(" ");

            System.out.println("Is the Node empty:"+ bt.isEmpty());
            System.out.println("");

            System.out.println("Sum of all node"+bt.SumOfAll(bt.root));
            System.out.println();

            System.out.println("Sum of all leaf nodes"+bt.SumOfLeaf(bt.root));

            System.out.println("print all leaf nodes");
            bt.allLeafNode(bt.root);

            System.out.println("Count of leaf node"+bt.countLeafNode(bt.root));

            sc.close();
    }
    static class BinaryTree {
        Node root;

        public void NodeVal(int data) {
            root = new Node(data);
        }
        public void insertLeft(Node root,int data) {
            root.left=new Node(data);
        }
        public void insertRight(Node root,int data) {
            root.right=new Node(data);
        }

        public void PreOrder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

        public void InOrder(Node root) {
            if (root == null) return;
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

        public void PostOrder(Node root) {
            if (root == null) return;
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        public int CountNode(Node node) {
            if (node == null) return 0;
            return 1 + CountNode(node.left) + CountNode(node.right);
        }

        public int Height(Node node) {
            if (node == null) return 0;
            int left = Height(node.left);
            int right = Height(node.right);
            return 1 + Math.max(left, right);
        }

        public boolean isEmpty() {
            return root == null;
        }

        public int SumOfAll(Node node) {
            if (node == null) return 0;
            return node.data + SumOfAll(node.left) + SumOfAll(node.right);
        }

        public int SumOfLeaf(Node node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) return node.data;
            return SumOfLeaf(node.left) + SumOfLeaf(node.right);
        }

        public void allLeafNode(Node node) {
            if (node == null) return;
            if (node.left == null && node.right == null) {
                System.out.println(node.data);
            }
            allLeafNode(node.left);
            allLeafNode(node.right);
        }

        public int countLeafNode(Node node) {
            if (node == null) return 0;
            if (node.left == null && node.right == null) return 1;
            return countLeafNode(node.left) + countLeafNode(node.right);
        }
    }
}
