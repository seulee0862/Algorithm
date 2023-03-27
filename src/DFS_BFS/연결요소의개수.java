package DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    static Node[]           nodes;
    static int              n;
    static int              m;
    static BufferedReader   br;
    static BufferedWriter   bw;

    public static void main(String[] args) throws IOException {

        input();
        int answer = 0;
        for (int i=1; i<=n; i++) {
            if (!nodes[i].visit) {
                dfs(nodes[i]);
                answer++;
            }
        }

        bw.write(answer+"");
        bw.close();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new Node[n+1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(nodes[b]);
            nodes[b].add(nodes[a]);
        }

    }

    static void dfs(Node node){
        node.visit = true;
        for (int i = 0; i < node.nodes.size(); i++) {
            if (!node.nodes.get(i).visit) {
                dfs(node.nodes.get(i));
            }
        }
    }

    static class Node{
        int no;
        ArrayList<Node> nodes = new ArrayList<>();
        boolean visit = false;

        public Node(int no) {
            this.no = no;
        }

        public void add(Node node){
            nodes.add(node);
        }
    }
}
