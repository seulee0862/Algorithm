package HASH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class 위장 {

    /**
     *
     * https://school.programmers.co.kr/learn/courses/30/lessons/42578
     *
     *  문제 설명
     * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
     *
     * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
     *
     * 종류	이름
     * 얼굴	동그란 안경, 검정 선글라스
     * 상의	파란색 티셔츠
     * 하의	청바지
     * 겉옷	긴 코트
     * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
     * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
     * 같은 이름을 가진 의상은 존재하지 않습니다.
     * clothes의 모든 원소는 문자열로 이루어져 있습니다.
     * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
     * 스파이는 하루에 최소 한 개의 의상은 입습니다.
     * 입출력 예
     * clothes	return
     * [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
     * [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
     *
     */

    /**
     *
     *  문제 접근 방법
     *
     *  1. 의상 종류를 트리의 계층처럼 생각한뒤 BFS형태로 전부 검색해야 하나 고민했지만 복잡하게 느껴졌음
     *  2. 의상 종류의 수를 통해서 몇가지 옷을 입을 수 있는지 규칙성을 찾아낼 것 같았음
     *     그렇지만 모자 2종류 얼굴 3종류 바지 2종류 와 같은 정보가 주어져도 정리가 안됐고
     *     경우의 수 공식에서 합의법칙, 곱의법칙을 찾아냈고 곱의법칙을 이용해 문제를 풀이하기 시작
     */

    /**
     *  참고자료 -> https://www.youtube.com/watch?v=i2atx-PJ_sw
     *
     *  합의 법칙 -> 동시에 일어날 수 없는 조합끼리는 더한다. ex) 1~100까지 카드중 5개 더해서 10의배수 찾기
     *  곱의 법칙 -> 동시에 일너날 수 있는 조합끼리는 곱한다 ex) 2개의 주사위로 나올 수 있는 합
     *  합, 곱의 법칙이 동시에 일어나는 경우도 있다. ex) 부산가는 경우의 수 => 차타고 부산가기, 기차타고 부산가기, 걸어서 부산가기
     */

    /**
     * 문제 풀이 방법
     *
     *  * 만약 cloeths가 빈값이면 0 반환
     *
     * 1. Queue, List생성
     * 2. clothes을 순회하면서
     *    clothes배열에 n행 1열의 값을 hashmap에 저장 존재하면 기본값1에+1 2초기화 또는 기존값 +1 ( 곱의법칙에선는 n^0 도 계산함 즉, 이 문제에서는 다른 것은 안입고 하나의 의상종류만 입는 경우를 더해주는 것과 같음)
     *    List에 해당옷종류가 포함돼있지 않다면 add (처음 옷종류에 대한 목록을 주지 않기 때문에 목록확인용)
     * 3. List의 0번째 키값을 answer에 저장한다
     * 4. list를 index 1부터 끝까지 순회하면서 answer * map.getValue(list[i])
     * 5. answer의 -1를 반환 ( 최소 한개의 의상을 입는다는 것은 하나도 안 입은경우는 제외하겠다는 뜻)
     *
     */

    /**
     *
     * 개선사항
     *
     * map을 Iterator 통해서 순회할 수 있다는걸 보고
     * List부분 주석처리후 리팩토링
     */

    public static void main(String[] args) {

        위장 main = new 위장();

        String[][] arr = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(main.solution(arr));
    }

    public int solution(String[][] clothes) {

        if (clothes.length == 0) return 0;

        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i< clothes.length; i++) {
            String str = clothes[i][1];
            map.put(str, map.getOrDefault(str, 1)+1);
        }

        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            answer *= it.next().intValue();
        }

        return answer-1;
    }

//    public int solution(String[][] clothes) {
//
//        if (clothes.length == 0) return 0;
//
//        int answer = 0;
//        HashMap<String, Integer> map = new HashMap<>();
//        ArrayList<String> list = new ArrayList<>();
//
//        for (int i=0; i< clothes.length; i++) {
//            String str = clothes[i][1];
//            map.put(str, map.getOrDefault(str, 1)+1);
//            if (!list.contains(str)) list.add(str);
//        }
//
//        answer += map.get(list.get(0));
//        for (int i=1; i< list.size(); i++) {
//            answer *= map.get(list.get(i));
//        }
//
//        return answer-1;
//    }
}