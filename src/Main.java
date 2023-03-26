import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N을 입력받는다
        int N = Integer.parseInt(br.readLine());
        //N크기만큼의 배열 arr을 생성한다
        int[] arr = new int[N];
        //N번돌면서 arr을 초기화한다
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //arr을 오름차순 정렬한다
        Arrays.sort(arr);

        //출력값 totalTip, 등수 초기화
        long totalTip = 0L;
        int sequence = 1;
        //arr의 가장큰값부터 배열을 순회
        for (int i = arr.length-1; i >= 0; i--) {
            //규칙에 맞게 totalTip값 증가
            int tip = arr[i] - (sequence++ - 1);
            if (tip > 0) totalTip += tip;
        }
        //출력
        System.out.println(totalTip);

    }
}
