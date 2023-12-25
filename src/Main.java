import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int size = N * 2 + 1;
		boolean[][] blankBoard = new boolean[size][size];

		setBoard(size, blankBoard);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (blankBoard[i][j]) {
					bw.write("  ");
				}
				else {
					bw.write("* ");
				}
			}
			bw.newLine();
		}

		bw.close();
	}

	private static void setBoard(int size, boolean[][] blankBoard) {
		for (int i = 1; i< size; i+=2) {
			for (int j = 1; j < size; j+=2) {
				blankBoard[i][j] = true;
			}
		}
	}
}
