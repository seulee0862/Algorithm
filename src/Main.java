import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 테이프길이가 수도의 간격+1cm보다 같거나 크면 이어붙이자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //물새는 갯수 N입력
        int N = Integer.parseInt(st.nextToken());
        //테이프길이 L입력
        int L = Integer.parseInt(st.nextToken());
        //N길이 배열 선언
        int[] arr = new int[N];
        //N번 반복하면서 배열초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 오름차순 정렬
        Arrays.sort(arr);
        //총 테이프 count 선언
        int totalUseTape = 0;
        //배열을 N-1번반복

        for (int i = 0; i < N; i++) {

            int useTape = 1;
            int totalLen = 0;

            while (i < N-1) {
                int len = arr[i+1] - arr[i];
                totalLen += len;
                if (len > L) {
                    break;
                }
                if (totalLen > (L*useTape) - 1 ) {
                    useTape++;
                }
                i++;
            }

            totalUseTape += useTape;
        }

        System.out.println(totalUseTape);
    }
}
