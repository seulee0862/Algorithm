package 정렬;

import java.io.*;
import java.util.Arrays;

public class 접두사 {

    //N입력 받는다
    //정렬.Spelling 이라는 클래스에 문자, 문자길이, includPrefix라는 변수선언
    //N번만큼 입력값을 받으면서 정렬.Spelling 배열초기화
    //배열 길이에 맞게 오름차순 정렬

    //N * N번 for문 반복하면서 i번째 단어가 j번쨰 단어에 포함되면
    //includPrefix true로변경후 continue
    //만약 둘이 같은단어라면 둘다 true로변경

    //count 0초기화
    //배열 돌면서 fasle면 count++
    //count출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Spelling[] arr = new Spelling[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = new Spelling(str);
        }
        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            String str = arr[i].str;
            for (int j = i+1; j < N; j++) {
                String tmpStr = arr[j].str;

                if (str.equals(tmpStr.substring(0, str.length()))) {
                    arr[i].includPrefix = true;
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!arr[i].includPrefix) count++;
        }

        System.out.println(count);
    }

}

class Spelling implements Comparable<Spelling> {

    String str;
    int strLen;
    boolean includPrefix;

    public Spelling(String str) {
        this.str = str;
        this.strLen = str.length();
        this.includPrefix = false;
    }

    @Override
    public int compareTo(Spelling o) {
        return this.strLen - o.strLen;
    }
}
