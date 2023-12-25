package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;
        }

        Comparator<String> comparator = Comparator
                .comparingInt(String::length)
                .thenComparing(String::compareTo);

        Arrays.stream(arr)
                .distinct()
                .sorted(comparator)
                .forEach(System.out::println);
    }
}
