package HASH;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    /**
     *
     * 문제 내용
     *
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     *
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
     * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     *
     * 접근 방법
     *
     *  * 전달받은 문자열목록을 2중 반복문과 substring메서드를 이용해 검증하려 했으나
     *    Hash 카테고리 문제여서 Hash로 접근하기로 생각함
     *
     *  * 전달받은 문자열을 통해 Hash Table을 생성후
     *    전달받은 목록의 문자에서 첫문자부터 ~ 끝문자까지 전부 확인후
     *    HashTable에 저장됐는지 확인
     *
     *    있다면 false
     *
     */

    /**
     *
     *  막혔던 부분
     *
     *  Hash문제라고 하니까 전달받은 문자열 배열을 통해
     *  바로 해당값을 찾아내야 한다고 생각하니 방법이 안 떠올랐다.
     *  substring으로 검색 가능한 경우를 모두 확인하는게 비효율적으로 느껴졌었다.
     *
     */

    /**
     *
     * 시간복잡도
     *
     * List를 통한 2중 반복문으로 검색했으면 최악의 경우 접두사를 찾기위해
     * 배열의 끝까지 확인하기 때문에
     * O(n^2) ~ O(n^3) 까지 갔을 것 같은데
     * 마지막에 Hash로 검색했기 떄문에
     * O(n^2)로 마무리 됐을 것 같다
     *
     */

    public static void main(String[] args) {

        전화번호목록 main = new 전화번호목록();

        String[] arr = {
                "123","456","789"
        };

        System.out.println(main.solution(arr));

    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, String> map = new HashMap<>();
        for (String str : phone_book) {
            map.put(str, str);
        }

        for (int i=0; i< phone_book.length; i++) {
            for (int j=0; j<phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return answer;
    }
}
