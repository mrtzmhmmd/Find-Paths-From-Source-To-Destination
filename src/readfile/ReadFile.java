package readfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class ReadFile {
	private String fileName;

	public ReadFile(String fileName) {
		this.fileName = fileName;
	}

	public int[][] readFileInArray() {
		List<String> list = Collections.emptyList();
		try {
			list = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int[][] arr = returnMatrix(list);
		return arr;
	}

	private int[][] returnMatrix(List<String> list) {
		int size = list.size();
		int[][] arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			String[] temp = list.get(i).split(" ");
			for (int j = 0; j < temp.length; j++) {
				arr[i][j] = Integer.valueOf(temp[j]);
			}
		}
		return arr;
	}
}
