package 강의.기초정렬알고리즘12가지;
//[?] 정렬되어 있는 데이터를 이진 검색(이분 탐색)을 사용하여 반씩 나눠서 검색
/**
 * 검색 알고리즘(Search Algorithm): 주어진 데이터에서 특정 데이터 찾기
 */
public class SearchAlgorithm {
	public static void main(String[] args) {
		//입력
		int[] data = {1, 3, 5, 7, 9}; // 오름차순 데이터(가정)
		int N = data.length;
		int search = 3; //검색할 데이터
		boolean flag = false;
		int index = -1;

		//처리
		int low = 0;
		int high = N - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data[mid] == search) {
				flag = true;
				index = mid;
				break;
			}

			if (data[mid] < search) {
				low = mid + 1;
			}

			if (data[mid] > search) {
				high = mid - 1;
			}
		}

		if (flag) {
			System.out.println(search + "를 " + index + "위치에서 찾았습니다.");
		}
		else {
			System.out.println("찾지 못했습니다.");
		}
	}
}
