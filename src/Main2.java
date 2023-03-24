import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());
        //N 루트값 구한뒤 정수값 M만 추출
        int M = (int)Math.sqrt(N);
        int count = 0;
        //만약 M+1의 제곱이 N과 같다면 1 출력
        if (Math.pow(M+1, 2) == N) {
            System.out.println(1);
        }
        //아니라면 아래 로직 실행
        else {
            //N이 0보다 크다면 반복
            //만약 M이 1이라면 count = count + N하고 종료
            //M의 제곱이 N보다 같거나 작다면 N값 M의 제곱값만큼 감소후 count증가
            //M감소
            while (N > 0) {
                if (M == 1) {
                    count += N;
                    break;
                }
                if (N >= Math.pow(M, 2)) {
                    N = N - (int)Math.pow(M, 2);
                    count++;
                }
                M--;
            }

            System.out.println(count);
        }

    }
}
