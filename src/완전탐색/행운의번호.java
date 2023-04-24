package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행운의번호 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] alphabet = new int[26];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        String str = br.readLine();

        for (char c : str.toCharArray()) {
            int asciiNum = c - 97;
            alphabet[asciiNum] = alphabet[asciiNum] + 1;
        }

        solution('#', str.length());

        System.out.println(count);
    }

    static public void solution(char preChar, int restAlphabetNum) {

        for (int i = 0; i < alphabet.length; i++) {

            if (alphabet[i] > 0) {

                int preCharAsciiNum = preChar - 97;
                if (i == preCharAsciiNum) {
                    continue;
                } else {
                    alphabet[i]--;

                    char c = (char) (i + 97);

                    //System.out.println("i = "+ i + " plusStr = " + plusStr);
                    solution(c, restAlphabetNum - 1);

                    alphabet[i]++;
                }

            }
        }

        if (restAlphabetNum == 0) {
            count++;
        }
    }

}
