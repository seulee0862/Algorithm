package 재귀;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 치킨TOPN {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int                  N, K;
    static int[]                arr;
    static ArrayList<Integer>   listForSort = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(br.readLine());


        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(K, 2);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + " ");
        }
        bw.close();
    }

    static void solution(int sortCount, int sortUnit) {

        //System.out.println("sortCount = " + sortCount + " sortUnit = " + sortUnit);

        int idx = 0;
        for (int i = 0; i < N; i++) {
            listForSort.add(arr[i]);
            if (i % sortUnit == sortUnit-1) { // 1
                //System.out.println("i = " + i + " sortUnit = " + sortUnit);
                Collections.sort(listForSort);
                for (int j = i - (sortUnit-1); j <= i; j++) {
                    arr[j] = listForSort.get(idx++);
                }
                listForSort.clear();
                idx = 0;
            }
        }

        if (sortUnit == N/K) {
            return;
        }
        else {
            solution(sortCount - 1, sortUnit * 2);
        }
    }
}