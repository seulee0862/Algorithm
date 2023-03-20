import java.io.*;
import java.util.StringTokenizer;

public class 캠프가는영식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //버스 대수 N
        int N = Integer.parseInt(st.nextToken());

        //버스정류장 도착시간T
        int T = Integer.parseInt(st.nextToken());

        //최소값 minTime MAXINTEGER초기화
        int minTime = Integer.MAX_VALUE;

        //N번만큼 반복
        //출발, 간격 ,대수 S I C 값 N번만큼 입력

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            //S가 T보다 같거나크다면 S-N 값 minTime과 비교
            if (S >= T) {
                minTime = Math.min(minTime, S-T);
            }
            //버스가 못오면 패스
            if (T > S+(I*C)) continue;

            //출발시간 + (I*C)가 T보다 같거나 크다면
            int count = 0;
            int time = S;
            // 버스 한대씩 올떄마다 count증가
            // count번쨰 왔을때 time 저장
            // 만약 time이 T보다 같거나 큰순간이 오면 최소값 비교후 break;
            while (count <C-1) {
                count++;
                time += I;
                if (time >= T) {
                    minTime = Math.min(minTime, time - T);
                    break;
                }
            }

        }

        //minTIme이 MAXINTEGER라면 -1출력
        if (minTime == Integer.MAX_VALUE)
            System.out.println(-1);
        //아니라면 minTIme출력
        else
            System.out.println(minTime);
    }
}
