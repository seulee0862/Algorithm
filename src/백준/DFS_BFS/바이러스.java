package 백준.DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {

    static boolean[] zombiePC;
    static List<ArrayList<Integer>> list;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 N을 받는다
        N = Integer.parseInt(br.readLine());
        // 컴퓨터 감염여부를 판단하는 배열을 N+1만큼 생선한다
        zombiePC = new boolean[N+1];
        // list를 타입으로 갖는 list를 n+1크기만큼 생성한다.
        list = new ArrayList<ArrayList<Integer>>(N+1);
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<Integer>());
            //list.get(4)- > 4번째리스트는 Integer
        }
        // 입력값 M을 받는다
        int M = Integer.parseInt(br.readLine());
        // M번만큼 반복한다
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // x, y -> x번째리스트 선택후 해당리스트에 y값을 추가한다
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        // 메서드 생성 (초기값 1로시작)
        infection(1);
        // 인덱스 idx번째의 리스트 길이만큼 반복문을 실행한다.
        // 1번쨰 리스트의 i번째 값을 확인한다
        // i번째 값이 true라면 넘어가고 false라면 true로 변경후 i번째 값으로 메서드 호출한다

        //모든 결과가 끝났을때 감염된 컴퓨터의 개수를 확인한다.
        int count = 0;
        for (int i = 1; i < zombiePC.length; i++) {
            if (zombiePC[i]) count++;
        }

        System.out.println(count-1);

    }

    static void infection(int idx) {
        List<Integer> idxList = list.get(idx);
        for (int i = 0; i < idxList.size(); i++) {
            Integer pcNum = idxList.get(i);
            if (!zombiePC[pcNum]){
                zombiePC[pcNum] = true;
                infection(pcNum);
            }
        }
    }

}
