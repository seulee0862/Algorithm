package 수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분수찾기 {

    /**
     *
     *  1번째 1/1
     *
     *  2번째 1/2
     *  3번째 2/1
     *
     *  4번째 1/3
     *  5번째 2/2
     *  6번째 3/1
     *
     *  7번째 1/4
     *  8번째 2/3
     *  9번째 3/2
     *  10번째 4/1
     *
     *  11번째 1/5
     *  12번째 2/4
     *  13번째 3/3
     *  14번째 4/2
     *  15번째 5/1
     *
     *  입력값이 n일때
     *  i를 1씩 증가시키면서 1부터 i까지의의 값이하로 n이 들어오면
     *  그 n은 1/i 부터 i/1 사이에 있는 값이다
     *
     *  분자를 x = 0, 분모를 y = i+1로 놓고
     *  n-1번만큼 x는 1증가 y는 1감소하면 원하는 값이나온다
     *
     *  지그재그라는 말을 잘 이해못했었다.
     *  i가 홀수일때는 분자랑 분모를 뒤집자
     *
     */
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i=1;
        int sum = 0;
        while (true) {
            sum += i;
            if (n <= sum) {

                int m = n - (sum-i);
                int x = 0;
                int y = i+1;

                if (i%2 == 0) System.out.println((x+m) + "/" + (y-m));
                else System.out.println((y-m) + "/" + (x+m));

                break;
            }
            i++;
        }
    }
}
