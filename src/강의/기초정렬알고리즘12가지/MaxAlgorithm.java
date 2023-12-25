package 강의.기초정렬알고리즘12가지;

//[?] 주어진 데이터 중에서 가장 큰 값

/**
 * 최댓값 알고리즘(Max Algorithm): (주어진 범위 + 주어진 조건)의 자료들의 가장 큰 값
 */
public class MaxAlgorithm {

	public static void main(String[] args) {
		//초기화
		int max = Integer.MIN_VALUE;

		//입력
		int[] numbers = {-2, -5, -3, -7, -1};

		//처리
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		//출력
		System.out.println("max = " + max);
	}
}
