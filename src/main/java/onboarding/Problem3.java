package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int answer = 0;

		int[] arr = new int[number + 1];
		for (int i = 1; i <= number; i++) {
			int num = i;
			while (num > 0) {
				if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
					arr[num] += 1;
					num = (int) (num / 10);
				} else {
					num = (int) (num / 10);
				}
			}
		}
		for (int i = 1; i <= number; i++) {
			answer += arr[i];
		}
		return answer;
	}
}
