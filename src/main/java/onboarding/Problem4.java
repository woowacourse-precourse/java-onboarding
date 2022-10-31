package onboarding;

public class Problem4 {

	public static String reverseStr(String str) {
		// 단어 하나하나씩 리버스한후 answer에 추가
		String answer = "";
		// 단어 하나씩 확인
		for (int i = 0; i < str.length(); i++) {
			char cha = str.charAt(i);
			// 문자가 A~Z 사이 대문자 라면
			if (65 <= Integer.valueOf(cha) && Integer.valueOf(cha) <= 90) {
				answer += Character.valueOf((char) ((char) (90 - Integer.valueOf(cha)) + 65));
				// 문자가 a~z 사이 소문자 라면
			} else if (97 <= Integer.valueOf(cha) && Integer.valueOf(cha) <= 122) {
				answer += Character.valueOf((char) ((char) (122 - Integer.valueOf(cha)) + 97));
				// 공백은 그냥 추가
			} else {
				answer += str.charAt(i);
			}
		}
		return answer;
	}

	public static String solution(String word) {
		return reverseStr(word);
	}
}
