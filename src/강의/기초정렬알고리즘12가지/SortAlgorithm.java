package 강의.기초정렬알고리즘12가지;
//[?] 무작위 데이터를 순서대로 [오름차순|내림차순] 정렬

/**
 * 정렬 알고리즘(Sort Algorithm): 가장 [작은|큰] 데이터를 왼쪽으로 순서대로 이동
 */
public class SortAlgorithm {
	public static void main(String[] args) {
		//[1] Input: Data Structure(Array, List, Stack, Queue, Tree, DB, ...)
		int[] data = { 3, 2, 1, 5, 4 };
		int N = data.length; // 의사코드(슈도코드) 형태로 알고리즘을 표현하기 위함

		//처리
		for (int i = 0; i < N - 1; i++) {
			for (int j = i+1; j < N; j++) {
				if (data[i] > data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}

		//출력
		for (int i = 0; i < N; i++) {
			System.out.println(data[i] + "\t");
		}
	}
}
