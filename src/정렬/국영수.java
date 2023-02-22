package 정렬;

import java.io.*;
import java.util.StringTokenizer;

public class 국영수 {

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
    static Student[] sort;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] arr = new Student[n];
        StringTokenizer st;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, korean, english, math);
        }
        sort = new Student[n];
        mergeSort(arr, 0, arr.length-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (Student st2 : arr) {
            bw.write(st2.name+"\n");
        }
        bw.close();

    }


    static void mergeSort(Student[] arr, int left, int right) {
        if (left<right) {

            int m = left+(right-left)/2; // == left_right/2와 동일하지만 오버플로 방지로 사용

            mergeSort(arr, left, m);
            mergeSort(arr, m+1, right);

            merge(arr, left, m, right);
        }
    }

    static void merge(Student[] arr, int left, int middle, int right) {

        int l = left;
        int r = middle + 1;
        int k = left;
        while (l <= middle && r <= right) {
            if (arr[l].compareTo(arr[r]) < 0) {
                sort[k] = arr[l];
                l++;
                k++;
            }
            else {
                sort[k] = arr[r];
                r++;
                k++;
            }
        }

        while (l <= middle) {
            sort[k] = arr[l];
            l++;
            k++;
        }
        while (r <= right) {
            sort[k] = arr[r];
            r++;
            k++;
        }

        for (int i=left; i<=right; i++) {
            arr[i] = sort[i];
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
