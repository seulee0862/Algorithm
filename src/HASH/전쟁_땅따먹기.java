package HASH;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 전쟁_땅따먹기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        //Map초기화
        HashMap<Long, Long> soldierMap = new HashMap<>();
        //N번만큼 알고리즘 수행
        while (N-- > 0) {
            //T입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            long T = Long.parseLong(st.nextToken());
            //T의 과반수값 저장하는 변수 halfOfT 초기화 T/2 + 1
            long moreThanHalf = (T/2) + 1;
            //dominatedNum = "SYJKGW"저장
            String dominateStr = "SYJKGW";

            //T번 반복하면서 병사번호 Map에 저장
            for (int i = 0; i < T; i++) {
                long soldierNum = Long.parseLong(st.nextToken());
                soldierMap.put(soldierNum, soldierMap.getOrDefault(soldierNum, 0L) + 1);

                //저장후 해당 번호가 toDomiateNum과 같다면 domiatedNum에저장
                long totalSoliderNum = soldierMap.get(soldierNum);
                // System.out.println(moreThanHalf+ " " + soldierNum + " " + totalSoliderNum);
                if (totalSoliderNum == moreThanHalf) {
                    dominateStr = String.valueOf(soldierNum);
                    break;
                }
            }

            //dominatedNum bw에 입력
            bw.write(dominateStr + "\n");
            soldierMap.clear();
            System.gc();
            // System.out.println("--------");
            //N반복
        }

        //출력
        bw.close();
    }
}