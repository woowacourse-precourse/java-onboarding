package onboarding;

public class Problem4 {

	/**
	 * 기능 목록 작성
	 * 1. 주어진 조건으로 문자 변환
	 */
	public static String solution(String word) {
		char[] alphabets = word.toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char alphabet : alphabets) {
			if (alphabet >= 65 && alphabet <= 90) {
				sb.append((char) (65 + (90 - alphabet)));
				continue;
			}
			if (alphabet >= 97 && alphabet <= 122) {
				sb.append((char) (97 + (122 - alphabet)));
				continue;
			}
			//알파벳을 제외한 모든 문자는 그대로 출력
			sb.append(alphabet);
		}
		return sb.toString();
	}
}
