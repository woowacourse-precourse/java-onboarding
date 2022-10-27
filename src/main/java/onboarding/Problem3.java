package onboarding;

public class Problem3 {
	public static int countClap(int index) {
		int count = 0;
		while (index > 0) {
			if (index % 10 == 3 || index % 10 == 6 || index % 10 == 9) {
				count++;
			}
			index /= 10;
		}
		return count;
	}

	public static int solution(int number) {
		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
		int number = 13;
		System.out.println(solution(number));
	}
}
