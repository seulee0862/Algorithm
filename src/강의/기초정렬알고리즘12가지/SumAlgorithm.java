package 강의.기초정렬알고리즘12가지;

// n명의 국어 점수중에서 80점 이상의 점수의 합계
/**
 * 합계 알고리즘
 * 주어진 범위에 주어진 조건에 해당하는 자료들의 합계
 */
public class SumAlgorithm {

	public static void main(String[] args) {
		//[1] input: n명의 국어 점수
		int[] scores = {100, 86, 50 ,30, 25 ,20};
		int sum = 0;

		//[2] Process: 합계 알고리즘 영역: 주우진 범위의 주어진 조건(필터링)
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= 80) {
				sum += scores[i];
			}
		}

		//[3] Output
		System.out.println(scores.length + "명의 점수 중  80점 이상의 총점: " + sum);
	}
}