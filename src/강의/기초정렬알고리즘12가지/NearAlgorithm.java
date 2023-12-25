package 강의.기초정렬알고리즘12가지;
//[?] 원본 데이터 중에서 대상 데이터와 가장 가까운 값

/**
 * 근삿값 알고리즘(Near Algorithm): 차잇값의 절댓값의 최솟값
 */
public class NearAlgorithm {

	public static int getAbs(int number) {
		return (number < 0) ? -number : number;
	}

	public static void main(String[] args) {
		//초기화
		int min =Integer.MAX_VALUE;
		//입력
		int[] numbers = {10, 20, 30, 27, 17};
		int target = 25;
		int near = 0;

		//처리
		for (int i = 0; i < numbers.length; i++) {
			int abs = getAbs(numbers[i]) - target;
			if (abs < min) {
				min = abs;
				near = numbers[i];
			}
		}

		//출력
		System.out.println("near = " + near);
	}
}
