package 완전탐색;

import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class 소수찾기 {


    /**
     *
     *  접근방법
     *
     *  * 모든숫자의 순열을 만든다
     *  * 중복값 제거
     *  * 소수인지 확인한다
     *
     *  구현방식 도움받기 위해 시청한 영상
     */

    /**
     *
     *  풀기위해 공부한 내용
     *  https://www.youtube.com/watch?v=pF368QqdQb4
     *
     *  * 에라토스테네스이 체는 루트를씌워서 가장큰 정수의 값까지만 확인하면 된다 ex) 80 -> 8까지확인
     *  * 알고리즘 공부라기보다는.. 문자열 재귀함수 돌리는 로직을 하나 알게됐다.
     */
    public static void main(String[] args) {
        소수찾기 main = new 소수찾기();

        String str = "17";
        main.solution(str);
    }

    HashSet<Integer> hashSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        recursive("",numbers);
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if(isPrimeNumber(num)) answer++;
        }

        System.out.println(answer);
        return answer;
    }

    /**
     *  순열값 생성해서 HashSet에 넣기
     */
    public void recursive(String str, String otherStr) {

        if (!str.equals("")) {
            hashSet.add(Integer.parseInt(str));
        }

        for (int i=0; i<otherStr.length(); i++) {
            recursive(str+otherStr.charAt(i),otherStr.substring(0, i)+otherStr.substring(i+1) );
        }
    }


    /**
     *  소수찾기
     */
    public boolean isPrimeNumber(int num) {

        //0과1은 소수가 아님
        if (num == 0 || num == 1) return false;

        //검사할 범위 구하기 루트값의 정수까지
        int limit = (int)Math.sqrt(num);

        //소수인지 판별하기
        for (int i=2; i<=limit; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
