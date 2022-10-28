package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		char [] cryptogramArray = cryptogram.toCharArray();

		for (int i = 1; i < cryptogramArray.length; i++) {
			if (cryptogramArray[i] == cryptogramArray[i + 1]) {
				System.out.println("중복된 문자열: " + cryptogramArray[i] + " " + cryptogramArray[i + 1]);
			}
		}

		String answer = "answer";
		return answer;
	}
}
