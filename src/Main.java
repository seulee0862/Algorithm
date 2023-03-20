import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //사람 입력
        int N = Integer.parseInt(br.readLine());

        //인출시간 입력
        int[] arr =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬
        Arrays.sort(arr);

        //waittime 변수 0으로 초기화, 총대기시간 time초기화
        int waitTime = 0;
        int time = 0;

        //반복문 돌면서 waittime += 앞에지금까지 기다린시간 + 현재사람 대기시간
        for (int i = 0; i < arr.length; i++) {
            time += waitTime + arr[i];
            waitTime = waitTime + arr[i];
        }

        System.out.println(time);
    }
}
