package 강의.기초정렬알고리즘12가지;
//[?] 2개의 정수 배열 합치기: 단, 2개의 배열은 오름차순으로 정렬되어 있다고 가정
/**
 * 병합 알고리즘(Merge Algorithm): 오름차순으로 정렬되어 있는 정수 배열을 하나로 병합
 */
public class MergeAlgorithm {
	public static void main(String[] args) {
		//[1] Input
		int[] first = { 1, 3, 5 };
		int[] second = { 2, 4 };
		int M = first.length; int N = second.length; // M:N 관행
		int[] merge = new int[M + N]; // 병합된 배열
		int i = 0; int j = 0; int k = 0; // i, j, k 관행

		//처리
		while (i < M && j < N) {
			if (first[i] < second[j]) {
				merge[k++] = first[i++];
			}
			else {
				merge[k++] = second[j++];
			}
		}

		while (i < M) {
			merge[k++] = first[i++];
		}
		while (j < N) {
			merge[k++] = second[j++];
		}

		//출력
		for (int item : merge) {
			System.out.print(item + " ");
		}
	}
}
