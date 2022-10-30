package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

	private static int numberCount(int num) {
		int n = 0;

		while(num > 0) {
			n++;
			num /= 10;
		}

		return n;
	}
}
