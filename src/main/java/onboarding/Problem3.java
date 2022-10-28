package onboarding;

public class Problem3 {
	public static int solution(int number) {
		ThreeSixNine threeSixNine = new ThreeSixNine(number);
		int answer = threeSixNine.run();
		return answer;
	}
}
