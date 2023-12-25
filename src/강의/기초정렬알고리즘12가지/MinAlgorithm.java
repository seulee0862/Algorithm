package 강의.기초정렬알고리즘12가지;

//[?] 주어진 데이터 중에서 가장 작은 [짝수] 값

/**
 * 최솟값 알고리즘(Min Algorithm): (주어진 범위 + 주어진 조건)의 자료들의 가장 작은 값
 */
public class MinAlgorithm {

	public static void main(String[] args) {
		//초기화
		int min = Integer.MAX_VALUE;
		//[2] Input: 이진수로 표현 + 숫자 구분자 사용({ 2, 5, 3, 7, 1 })
		int[] numbers = { 0b0010, 0B0101, 0b0011, 0B0111, 0b0000_0001 };

		//처리
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < min && numbers[i] % 2 == 0) {
				min = numbers[i];
			}
		}

		//출력
		System.out.println("min = " + min);
	}
}
