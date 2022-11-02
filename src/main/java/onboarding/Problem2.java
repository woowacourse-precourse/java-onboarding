package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		//1. 암호 문자열을 스트링 버퍼로(인덱스 참조해 delete 메서드를 쓰기 위해)
		StringBuffer decryption = new StringBuffer(cryptogram);
		//2. 중복되는 문자 제거
		for (int i = 1; i < decryption.length(); i++) {
			if (decryption.charAt(i - 1) == decryption.charAt(i)) {
				for (int j = i; j < decryption.length(); j++) {
					if (decryption.charAt(i - 1) == decryption.charAt(j)) {
						decryption.delete(i - 1, j + 1);
						i = 1;
					}
				}
			}
		}
		//3. 정답제출 전 정답 스트링 인덱스 0,1이 같으면 "" 리턴 메서드
		String answer = decryption.toString();
		if (answer.length() == 0 || answer.charAt(0) == answer.charAt(1)) {
			answer = "";
		}
		// 정답제출
		return answer;
	}
}