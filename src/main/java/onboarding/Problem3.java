package onboarding;

public class Problem3 {
	public static int solution(int number) {

		int answer = 0;

		for (int i = 1; i <= number; i++) {
			int a = i / 1000;
			int b = (i - a * 1000) / 100; 
			int c = (i - a * 1000 - b * 100) / 10; 
			int d = i - a * 1000 - b * 100 - c * 10; 

			if (d == 3 || d == 6 || d == 9)
				answer++;
			if (c == 3 || c == 6 || c == 9)
				answer++;
			if (b == 3 || b == 6 || b == 9)
				answer++;
			if (a == 3 || a == 6 || a == 9)
				answer++;
		}

		return answer;
	}

}
