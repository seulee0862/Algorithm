package 백준.완전탐색;

public class 카펫 {


    /**
     *
     *  https://school.programmers.co.kr/learn/courses/30/lessons/42842
     *
     *  가로의 길이가 yellow 세로의 길이가 1인 격자부터 시작해서
     *  가로의길이가 세로보다 크거나 같을때까지 반복한다
     *
     *  격자가 한번 만들어질때 yellow를 둘러싼 격자의 갯수는
     *  yellow격자의 세로x2 + 가로x2 + 4(양옆모서리)로 정해지며
     *  만약 이때 계산된 둘러싼 격자의 갯수가 전달받은 brown의 갯수와 같다면
     *  answer[ yellow 가로길이 +2, yellow 세로길이 +2 ] 를반환한다.
     */

    /**
     *    위 로직에서 반례발견
     *
     *    반례예시 4004, 999999 -> 맞는답 1003, 1001
     *    반례예시 404, 9999 -> 맞는답 103, 101
     *
     *    원인
     *
     *    가로의 길이가 yellow 세로의 길이가 1인 격자부터 시작해서
     *    가로의길이가 세로보다 크거나 같을때까지 반복한다 의 부분에서
     *    세로의 길이가 가로의길이의 약수여야만 사각형 모형으로 나오는건데
     *    이부분을 생각못하고 세로길이++ 로 재귀함수를 호출시켰다
     *
     *    해결책
     *
     *    무한루프 방지를 위해 처음에는 +1 그 이후
     *    재귀함수를 타기전에 세로의길이가 yellow의 약수가 되지 않으면
     *    될때까지 세로++;
     *    이후 재귀호호출
     */

    /**
     *  시간복잡도는 O(log n)
     */

    public static void main(String[] args) {
        카펫 main = new 카펫();

        for (int x : main.solution(404, 9999)) {
            System.out.print(x+" ");
        }

    }

    int[] answer = new int[2];

    public int[] solution(int brown, int yellow) {

        recursive(yellow, 1, yellow, brown, 1);
        return answer;
    }

    public void recursive(int colLen, int rowLen,int yellow, int brown, int L) {

        int grid = colLen*2 + rowLen*2 + 4;
        if (grid == brown) {
            answer[0] = colLen+2;
            answer[1] = rowLen+2;
        }
        else {
            L++;
            while (yellow % L != 0) L++;
            recursive(yellow/L, 1+(L-1), yellow, brown, L);
        }
    }
}
