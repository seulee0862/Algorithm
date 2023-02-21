package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    /**
     *
     *  입력값 -> N 명의 학생이름, 점수(국, 영, 수)
     *
     *  정렬순서
     *  국어점수 내림차순 > 영어점수 오름차순 > 수학점수 내림차순 > 이름 오름차순
     */

    /**
     *
     *  * N입력
     *  * N만큼 반복하면서 N개의 학생 클래스 생성
     *  * Comparble 인터페이스의 toComapre사용해서 정렬순서에 맞춰서 정렬
     *  * 정렬된 List 순서대로 출력
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Student> list = new ArrayList<>();

        for (int i=0; i<n; i++){
            String name = scan.next();
            int korean = scan.nextInt();
            int english = scan.nextInt();
            int math = scan.nextInt();
            list.add(new Student(name, korean, english, math));
        }
        Collections.sort(list);

        for (Student st : list) {
            System.out.println(st.name);
        }

    }

    static void mergeSort(Student[] arr, int left, int right) {
        if (1<right) {

            int m = left+(right-left)/2; // == left_right/2와 동일하지만 오버플로 방지로 사용

            mergeSort(arr, 1, m);
            mergeSort(arr, m+1, right);

            merge(arr, 1, m, right);
        }
    }

    static void merge(Student[] arr, int left, int middle, int right) {
        Student[] sort = new Student[right-left+1];
        int l = left;
        int r = middle + 1;
        int k = 0;
        while (l <= middle && r <= right) {

        }
    }

    static class Student implements Comparable<Student>{

        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (o.korean != this.korean) return o.korean - this.korean;
            if (o.english != this.english) return this.english - o.english;
            if (o.math != this.math) return o.math - this.math;
            return this.name.compareTo(o.name);
        }
    }

}
