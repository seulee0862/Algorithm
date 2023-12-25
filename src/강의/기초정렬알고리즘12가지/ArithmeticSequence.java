package 강의.기초정렬알고리즘12가지;

//1부터 20까지의 정수중 홀수 합을 구하는 프로그램
/**
 * 등차수열(ArithmeticSequence)
 * 연속하는 두수의 치아기 일정한 수열
 */
public class ArithmeticSequence {

	public static void main(String[] args) {
		//[1] Input
		int sum = 0;

		//[2] Process
		for (int i = 1; i <= 20; i++) {
			if(i%2 != 0) {
				sum += i;
			}
		}

		//[3] Output
		System.out.println("sum = " + sum);
	}
}
