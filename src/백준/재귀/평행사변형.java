package 백준.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 평행사변형 {

    /**
     *
     *
     *
     */
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static String[] chArr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Long x = Long.parseLong(st.nextToken());

        chArr = new String[n+1];

        createBurger(n);
        String burger = sb.toString();

        Long count = 0L;
        for (int i = 0; i < x; i++) {
            if (burger.charAt(i) == 'P') count++;
        }

        System.out.println(count);
    }

    static void createBurger (int n) throws IOException {

        if (chArr[n] != ""){
            sb.append(chArr[n]);
        }
        else if (n == 0) {
            sb.append("P");
        }
        else {
            sb.append("B");
            createBurger(n-1);
            sb.append("P");
            createBurger(n-1);
            sb.append("B");

        }
    }

}
