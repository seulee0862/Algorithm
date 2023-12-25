package 백준.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 현시점에서 회의시간이 가장 짧은걸 선택하자
         */

        //N입력
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetingArr = new Meeting[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingArr[i] = new Meeting(start, end);
        }

        Arrays.sort(meetingArr);

        int time = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            int startMeet = meetingArr[i].start;
            int endMeet = meetingArr[i].end;
            if (startMeet >= time) {
                time = endMeet;
                count++;
            }
        }

        System.out.println(count);
    }

    static class Meeting implements Comparable<Meeting>{

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end){
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}