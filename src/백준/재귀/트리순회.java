package 백준.재귀;

import java.io.*;
import java.util.*;

public class 트리순회 {

    static Node head = new Node('A', null, null);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            nodeInsert(head, root, left, right);
        }

        preOrder(head);
        bw.write("\n");
        inOrder(head);
        bw.write("\n");
        postOrder(head);
        bw.close();


    }


    static void nodeInsert(Node temp, char root, char left, char right) {

        if (temp.value == root) {

            temp.left = (left == '.' ? null : new Node(left, null, null));
            temp.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            if (temp.left != null)  nodeInsert(temp.left, root, left, right);
            if (temp.right != null) nodeInsert(temp.right, root, left, right);
        }
    }

    static void preOrder(Node node) throws IOException{
        if (node == null) return;
        bw.write(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) throws IOException{
        if (node == null) return;
        inOrder(node.left);
        bw.write(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) throws IOException{
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        bw.write(node.value);
    }


}

class Node {

    char value;
    Node left;
    Node right;

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}