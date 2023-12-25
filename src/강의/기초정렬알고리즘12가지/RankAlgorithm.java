package 강의.기초정렬알고리즘12가지;
//[?] 주어진(지정한 범위) 데이터의 순위(등수)를 구하는 로직

/**
 * 순위 알고리즘(Rank Algorithm): 점수 데이터에 대한 순위 구하기
 */
public class RankAlgorithm {

	public static void main(String[] args) {
		//입력
		int[] scores = { 90, 87, 100, 95, 80 }; // 등수: 3, 4, 1, 2, 5
		int[] rankings = { 1, 1, 1, 1, 1 }; // 모두 1로 초기화

		//처리
		for (int i = 0; i < scores.length; i++) {
			rankings[i] = 1;
			for (int j = 0; j < scores.length; j++) {
				if (scores[i] < scores[j]) {
					rankings[i]++;
				}
			}
		}

		//출력
		for (int i = 0; i < scores.length; i++) {
			System.out.println(String.format("%5d점: %5d등", scores[i], rankings[i]));
		}
	}
}
