import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static class TestNode<E> {
        E data;
        TestNode<E> next;
        // MyNode<E> prev; // for doubly-linked

        TestNode(E data) {
            this.data = data;
            // next = null; // redundant
        }
    }

    static class Abitur implements Comparable<Abitur> {
        public double gpa;

        public Abitur(double gpa) {
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Abitur another) {

            // this > another
            if (this.gpa > another.gpa) {
                return 1;
            } else if (this.gpa < another.gpa) {
                return -1;
            }

            return 0;
        }
    }

//    public static class Node {
//        private int key;
//        private String value;
//        private Node next;
//
//        public Node(int key, String value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public String toString() {
//            return key + "(" + value + ")";
//        }
//    }
//
//    static int M = 11;
//    public static Node[] heads = new Node[M];



    private static class Node {
        private int key;
        private String value;
        private Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "(" + value + ")";
        }
    }

    private static Node root;

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9,1,2,4,6,5,19,15,-4,8,19,3,7,6,13};


        int pi = 9, k = 3, z = 8;

        while(k < z) {
            if (a[pi] < a[k]) {
                for (; z > k; z--) {
                    if (a[pi] > a[z]) {
                        swap(a, k, z);
                        z--;
                        break;
                    }
                }
            }
            k++;
        }

        swap(a, k, pi);


        for (int e : a) {
            System.out.print(e + " ");
        }
    }

    public static void print() {

    }

    public static void insert(int key, String value) {
        Node newNode = new Node(key, value);
        root = recursiveInsert(newNode, root);
    }

    private static Node recursiveInsert(Node newNode, Node current) {
        if (current == null) return newNode;

        if (newNode.key > current.key) {
            current.right = recursiveInsert(newNode, current.right);
        } else {
            current.left = recursiveInsert(newNode, current.left);
        }

        return current;
    }
}