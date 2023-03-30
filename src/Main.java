import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //게임횟수 X를 입력받는다
        double X = Integer.parseInt(st.nextToken());
        //이긴횟수 Y를 입력받는다
        double Y = Integer.parseInt(st.nextToken());
        //Y/X로 승률 Z를 구한다
        int Z  = (int)((Y/X) * 100);

        //X랑 Y가 같다면 -1, Z가 99라면 -1출력후 종료
        if (X == Y || Z == 99) {
            System.out.println(-1);
            System.exit(0);
        }

        //count를 0으로 초기화한다.
        int count = 0;
        //반복문 true시작
        while (true) {
            //X, Y를 증가, count증가
            X++;
            Y++;
            count++;
            //Y/X의 정수값이 Z보다 1크다면 brak;
            int winPercent = (int)((Y/X) * 100);
            if (winPercent > Z) {
                break;
            }
        }

        //count 출력
        System.out.println(count);
    }
}
