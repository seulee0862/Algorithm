package 백준.재귀;

import java.io.*;

public class 재귀의귀재 {

    static int count = 0;
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            int num = recursive(str, 0, str.length() - 1);
            bw.write(num+" "+count+"\n");
            count = 0;
        }

        bw.flush();
        bw.close();
    }

    static int recursive(String str, int l, int r) {
        
        count++;
        
        if (l >= r) return 1;
        else if (str.charAt(l) != str.charAt(r)) return 0;
        else return recursive(str, l+1, r-1);
    }

    static int isPalindrome(String str) {
        return recursive(str, 0, str.length()-1);
    }
}
