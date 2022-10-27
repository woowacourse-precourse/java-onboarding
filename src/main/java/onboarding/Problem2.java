package onboarding;

// brooown인경우는?
public class Problem2 {
	public static String solution(String cryptogram) {
		String answer = "answer";
		do {
			cryptogram = cryptoSolve(cryptogram);
		} while (continueWord(cryptogram));
		answer = cryptogram;
		return answer;
	}

	public static String cryptoSolve(String code) {
		char temp = code.charAt(0);
		for (int i = 1; i < code.length(); i++) {
			if (code.length() == 2 && code.charAt(0) == code.charAt(1)) //indexout 에러 방지
				return "";
			if (code.charAt(i) == temp) {
				code = code.substring(0, i - 1) + code.substring(i + 1);
				i--;
			}
			temp = code.charAt(i);
		}
		return code;
	}

	public static boolean continueWord(String code) //중복 문자가 있는지 확인
	{
		for (int i = 0; i < code.length() - 1; i++) {
			if (code.charAt(i) == code.charAt(i + 1))
				return true;
		}
		return false;
	}
}

