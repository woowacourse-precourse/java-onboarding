package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

	private static class Frog {
		private static class Letter {
			private static final int UPPER_CASE_A = 65;
			private static final int UPPER_CASE_Z = 90;
			private static final int LOWER_CASE_A = 97;
			private static final int LOWER_CASE_Z = 122;

			private static int toReversedCode(int letterCode) {
				if (Character.isLowerCase(letterCode)) {
					return (LOWER_CASE_Z - (letterCode- LOWER_CASE_A));
				}
				if (Character.isUpperCase(letterCode)) {
					return (UPPER_CASE_Z - (letterCode - UPPER_CASE_A));
				}
				return letterCode;
			}
		}
	}
}
