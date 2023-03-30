import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N을 입력받는다
        int N = Integer.parseInt(br.readLine());

        //검사시작
        //N이 100 미만이면 N출력후 종료
        if (N < 100) {
            System.out.println(N);
            return;
        }
        //N이 111 미만이면 99출력후 종료
        if (N < 111) {
            System.out.println(99);
            return;
        }

        //한수 count 선언한다
        int count = 99;
        //111 ~ N까지 값을 구하면서
        //100의 자리수 10의자리수 1의 자리수를 구한다.
        for (int i = 111; i <= N; i++) {
            int temp = i;
            int hundred = temp/100;
            temp = temp%100;
            int ten = temp/10;
            temp = temp%10;
            int one = temp;

            //100의 자리수 + d의 값이 10의자리수랑 같고
            //100의 자리수 + 2d의 값이 1의자리수랑 같다면
            //해당값을 한수로 저장한다
            int d1 = ten - hundred;
            int d2 = one - ten;
            if (d1 == d2) {
                count++;
            }
        }

        //한수 출력
        System.out.println(count);
    }
}
