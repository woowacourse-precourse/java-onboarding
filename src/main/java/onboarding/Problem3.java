package onboarding;

public class Problem3 {

	public static boolean check369(char num) {
		if (num == '3'||num == '6'||num == '9') {
			return true;
		}
		return false;
	}

	public static int count369(String fullNumber) {
		int count = 0;

		for (int i = 0; i<fullNumber.length(); i++) {
			if (check369(fullNumber.charAt(i))) {
				count += 1;
			}
		}
		return count;
	}

    public static int solution(int number) {
        int answer = 0;

		for (int i = 1; i<=number; i++) {
			answer += count369(String.valueOf(i));
		}
        return answer;
    }
}
