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

	private static int maxNumber(int num, int length) {
		int div = 1;

		for(int i = 0;i < length - 1;i++)
			div *= 10;

		return num / div;
	}
}
