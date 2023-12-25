package 강의.기초정렬알고리즘12가지;
//[?] 컬렉션 형태의 데이터를 특정 키 값으로 그룹화

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 그룹 알고리즘(Group Algorithm): 특정 키 값에 해당하는 그룹화된 합계 리스트 만들기
 */
public class GroupAlgorithm {

	/**
	 * 테스트용 레코드 클래스
	 */
	public static class Record {
		private final String name; // 상품명
		private final int quantity; // 수량

		public Record(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}

		public String getName() {
			return name;
		}

		public int getQuantity() {
			return quantity;
		}
	}

	//[0][1] 테스트용 데이터 채우기용 로컬 함수
	public static List<Record> getAll() {
		return  Arrays.asList(
			new Record("RADIO", 3),
			new Record("TV", 1),
			new Record("RADIO", 2),
			new Record("DVD", 4)
		);
	}

	//[0][2] 컬렉션 데이터 출력용 로컬 함수
	public static void printData(String message, List<Record> data) {
		System.out.println(message);
		for (Record item : data) {
			System.out.println(String.format("%5s - %d", item.getName(), item.getQuantity()));
		}
	}

	public static void main(String[] args) {
		//[1] Input
		List<Record> records = getAll(); // 입력 데이터
		List<Record> groups = new ArrayList<Record>(); // 출력 데이터
		int N = records.size(); // 의사코드

		//[2] Process: Group 알고리즘(SORT -> SUM -> GROUP)
		//[A] 그룹 정렬: SORT
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (records.get(i).getName().compareTo(records.get(j).getName()) > 0) {
					Record t = records.get(i);
					records.set(i, records.get(j));
					records.set(j, t);
				}
			}
		}

		//[B] 그룹 소계: GROUP
		int subtotal = 0;
		for (int i = 0; i < N; i++) {
			subtotal += records.get(i).getQuantity();
			if ((i+1) == N || //size 1일경우 무시
			(records.get(i).getName() != records.get(i + 1).getName())) {
				//다음 레코드랑 현재 레코드가 다르면 그룹에 저장
				Record r = new Record(records.get(i).getName(), subtotal);
				groups.add(r);

				subtotal = 0; // 소계 초기화
			}
		}

		//[3] Output
		printData("[1] 정렬된 원본 데이터:", records);
		printData("[2] 이름으로 그룹화된 데이터:", groups);
	}
}
