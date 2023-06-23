package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Map<String, Integer> bookMap = new HashMap<>();
        ArrayList<Book> bookList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
        }

        bookMap.forEach((name, count) -> {
            bookList.add(new Book(name, count));
        });

        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.count == o2.count) {
                    return o1.name.compareTo(o2.name);
                }
                else {
                    return o2.count - o1.count;
                }
            }
        });

        System.out.println(bookList.get(0).name);

    }
}

class Book{

    String name;
    int count;

    public Book(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
