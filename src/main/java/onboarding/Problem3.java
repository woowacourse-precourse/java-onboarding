package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int cnt = 0;
		String strNumber = "";
		char oneLetter = ' ';

		for (int i = 1; i <= number; i++) {
			strNumber = String.valueOf(i); // int -> string 변환

			// 예를 들어, 36 이라는 숫자에는 박수 두 번
			for (int j = 0; j < strNumber.length(); j++) {
				oneLetter = strNumber.charAt(j);
				if (oneLetter == '3' || oneLetter == '6' || oneLetter == '9') {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
