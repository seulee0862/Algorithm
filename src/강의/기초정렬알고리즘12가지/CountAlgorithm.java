package 강의.기초정렬알고리즘12가지;

// 1부터 1000까지의 정수 중 13의 배수의 개수(건수, 횟수)
/**
 * 개수 알고리즘
 * 주어진 범위에 주어진 조건에 해당하는 자료들의 개수
 */
public class CountAlgorithm {

	public static void main(String[] args) {
		//입력
		int[] numbers = {11, 12, 13, 13, 15, 13};
		int count = 0;

		//처리
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 13 == 0) {
				count++;
			}
		}
		//출력
		System.out.println("count = " + count);
	}
}
