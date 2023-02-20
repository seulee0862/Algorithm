package 정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class H_Index {

    /**
     *
     *  https://school.programmers.co.kr/learn/courses/30/lessons/42747
     *
     *  문제 설명
     * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
     *
     * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
     *
     * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
     * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
     * 입출력 예
     * citations	return
     * [3, 0, 6, 1, 5]	3
     *
     */

    /**
     *
     *  접근 방식
     *
     *  * 논문 인용 횟수를 담은 배열 오름차순 정렬
     *  * 배열의 i 번째 값과 배열의 길이를 논문횟수에 사용해 문제를 풀으려했지만 어려워서 구글링
     */

    /**
     *
     *  알아야 하는 포인트
     *
     *  * 배열[i] 번째의 값이 배열길이(논문횟수)의 앞에있는 값일수록 최대값이다.
     *  * 배열[i] 번째의 값이랑 배열길이-i의 값을 비교하는 것을 통해서 현재 배열[i]값이 문제의 요구조건에 맞는지 알 수 있다.
     *
     *  * 배열 오름차순후 위의 조건에 맞는 값 바로 return하면 끝
     */

    /**
     * 어려웠던점
     *
     * 문제의 요구조건과 주어진 값 자체를 이해하는건 어렵지 않았는데
     * 요구조건과 값의 관계를 통해서 원하는 값을 도출해내는 방식이 자꾸만 복잡하게 느껴져서 어려웠다.
     * 한줄씩 차근차근 하다가 생각보다 시간이 지체되는 것 같아서 풀이를 보고 이해후 풀었다.
     */

    public static void main(String[] args) {
        H_Index main = new H_Index();
        int[] arr = {3, 0, 6, 1, 5};
        System.out.println(main.solution(arr));

    }

    public int solution(int[] citations) {
        int answer = 0;

        int n, count =citations.length;
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            count = citations.length - i;
            if (citations[i] >= count) {
                answer = count;
                break;
            }
        }

        return answer;
    }

}
