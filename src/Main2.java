import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Str 입력받는다
        String str = br.readLine();
        //minValue 값 반복문 통해서 초기화 -> str은 -12.. +11..형태로 변경
        //sum
        int minValue = 0;
        int sum = 0;
        int idx = 0;
        boolean plus = false;
        // 0055 + 1122 - 33
        while (true) {
            char c = str.charAt(idx);
            if (c == '0') {
                str = str.substring(1);
            }
            else if (c == '+') {
                int num = Integer.parseInt(str.substring(0, idx));
                minValue += num;
                plus = true;
                break;
            }
            else if (c == '-') {
                int num = Integer.parseInt(str.substring(0, idx));
                minValue += num;
                plus = false;
                break;
            }
            else {
                idx++;
            }
        }

        //str 이 ""이 될때까지 반복
        //str의 0번째가 i라면 str = substring(1)로 초기화
        //str의 idx번째가 +라면 plus true
        // 아니라면 false로 변경후 str 0번쨰 문자 잘라내기
        idx = 0;
        while (str != "") {

            char c = str.charAt(idx);
            if (c == '0') {
                str = str.substring(0);
            }
            else if (c == '+') {
                int num = Integer.parseInt(str.substring(0, idx));
                if (plus){
                    minValue += num;
                }
                else {
                    minValue -= num;
                }
                plus = true;
                str = str.substring(0, idx+1);
            } else if (c == '-') {
                int num = Integer.parseInt(str.substring(0, idx));
                if (plus){
                    minValue += num;
                }
                else {
                    minValue -= num;
                }
                plus = false;
                str = str.substring(0, idx+1);
            }
            else {
                idx++;
            }
        }

        System.out.println(minValue);



    }
}
