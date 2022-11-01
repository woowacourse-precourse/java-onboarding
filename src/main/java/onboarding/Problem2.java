package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		validateCryptogram(cryptogram);

		String answer = "";

		while(!answer.equals(cryptogram)){
			answer = removeDuplicate(cryptogram);
			cryptogram = removeDuplicate(answer);
		}

		return answer;
	}

	/**
	 * 주어진 문자열에 대한 유효성 검사
	 * @param cryptogram
	 */
	public static void validateCryptogram(String cryptogram) {
		if(cryptogram.length() > 1000 || cryptogram.length() < 1) throw new IllegalArgumentException();
		if(!cryptogram.matches("^[a-z]*$")) throw new IllegalArgumentException();
	}

	/**
	 * 주어진 문자열에 대한 연속하는 중복을 제거
	 * @param cryptogram
	 * @return
	 */
	public static String removeDuplicate(String cryptogram){
		return cryptogram.replaceAll("(([a-z])\\2{1,})", "");
	}
}
