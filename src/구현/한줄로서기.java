package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class 한줄로서기 {
    static int N;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //6
        //5 4 3 2 1 0
        //출력
        //6 5 4 3 2 1

        //N을 입력 받는다
        N = Integer.parseInt(br.readLine());
        //입력값을 받는다
        arr = new int[N];
        answer = new int[N];
        //1~N의 키를가진사람 왼쪽에 서있는 사람중 더 키가 큰 사람의 합을 구한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //1번째 사람의 위치는 1번째 값 번쨰 이후에 위치한다 + 이미 서있는 자리는 제외한다
        //2번째 사람의 위치는 2번째 값 번째 이후에 위치할 수 있다. + 이미 서있는 자리는 제외한다
        //3번째 사람의 위치는 3번째 값 번째 이후에 위치할 수 있다. + 이미 서있는 자리는 제외한다
        //4번째 사람의 위치는 4번째 값 번째 이후에 위치할 수 있다. + 이미 서있는 자리는 제외한다
        // ..

        //N번만큼 위에 규칙대로 정렬하면서 할때마다 맞는지 검증
        for (int i = 0; i < N; i++) {
            int k = arr[i];
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (idx == k) {
                    if (answer[j] != 0) continue;
                    answer[j] = i+1;
                    break;
                }
                if (answer[j] == 0) idx++;
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(answer[i]+" ");
        }
        bw.close();
    }
}