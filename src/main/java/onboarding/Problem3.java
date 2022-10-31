package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
	public static List<Integer> buildList(int number) {
		List<Integer> list = new ArrayList<>(number);
		IntStream.rangeClosed(1, number)
			.forEach(i -> {
				while (i > 0) {
					list.add(i % 10);
					i /= 10;
				}
			});
		return list;
	}

	public static int countNumber(List<Integer> list) {
		int count = (int)list.stream()
			.map(n -> Integer.toString(n))
			.filter(n -> n.contains("3") || n.contains("6") || n.contains("9"))
			.count();
		return count;
	}

	public static int solution(int number) {
		int answer;
		List<Integer> list = buildList(number);
		answer = countNumber(list);
		return answer;
	}
}
