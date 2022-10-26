package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

class Problem1 {
	public static int getScore(List<Integer> pageList) {
		int max = Integer.MIN_VALUE;
		int[] numList;
		int add;
		int mul;

		for (int page : pageList) {
			String number = String.valueOf(page);
			numList = Stream.of(number.split("")).mapToInt(Integer::parseInt).toArray();
			add = Arrays.stream(numList).sum();
			mul = Arrays.stream(numList).parallel().reduce(1, (a, b) -> a * b);
			max = Math.max(Math.max(add, mul), max);
		}
		return max;
	}

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer;

		int pobiScore = getScore(pobi);
		int crongScore = getScore(crong);

		System.out.println("pobiScore = " + pobiScore);
		System.out.println("crongScore = " + crongScore);
		if (pobiScore > crongScore) {
			answer = 1;
		} else if (pobiScore < crongScore) {
			answer = 2;
		} else {
			answer = 0;
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> pobi = new ArrayList<>();
		List<Integer> crong = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());

			if (i == 0) {
				pobi.add(v);
				pobi.add(u);
			} else {
				crong.add(v);
				crong.add(u);
			}
		}

		System.out.println("pobi = " + pobi);
		System.out.println("crong = " + crong);

		System.out.println(solution(pobi, crong));

	}
}
