package 백준.재귀;

import java.io.*;

public class 재귀함수가뭔가요 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        questionToRobot(n, "");

        bw.close();

    }

    static void questionToRobot(int n, String tap) throws IOException{

        if (n == -1) return;

        if (n == 0) {
            bw.write(tap + "\"재귀함수가 뭔가요?\"\n");
            bw.write(tap + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }
        else {
            bw.write(tap + "\"재귀함수가 뭔가요?\"\n");
            bw.write(tap + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.write(tap + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.write(tap + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }

        questionToRobot(n-1, tap+"____");

        bw.write(tap + "라고 답변하였지.\n");
    }
}

