package 백준.수학;

import java.io.*;
import java.util.StringTokenizer;

public class 다면체 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int edgePoint = Integer.parseInt(st.nextToken());
            int edgeLine = Integer.parseInt(st.nextToken());
            sb.append((edgePoint - edgeLine - 2) * -1 + "\n");
            //bw.write((edgePoint - edgeLine - 2) * -1 + "\n");
        }
        //bw.close();
        System.out.println(sb.toString());
    }
}
