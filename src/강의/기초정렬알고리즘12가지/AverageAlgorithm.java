package 강의.기초정렬알고리즘12가지;

//[?] n명의 점수 중에서 80점 이상 95점 이하인 점수의 평균

/**
 * 평균 알고리즘(Average Algorithm): 주어진 범위에 주어진 조건에 해당하는 자료들의 평균
 */
public class AverageAlgorithm {

	public static void main(String[] args) {
		//입쳑
		int[] data = {90, 65, 78, 50, 95};
		int sum = 0;
		int count = 0;

		//처리
		for (int i = 0; i < data.length; i++) {
			if (data[i] >= 80 && data[i] <= 95) {
				sum += data[i];
				count++;
			}
		}
		double avg = sum / (double)count;

		//출력
		System.out.println("avg = " + avg);

	}
}
