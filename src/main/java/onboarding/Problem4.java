package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";
		// String word -> char[] 형 변환 && ascii 번호와 반대 문자 전환을 위한 절댓값 변수 설정
		char[] c = word.toCharArray();
		int ascNum = 0;
		int abs = 0;

		for (int i = 0; i < c.length; i++) {
			if ((int) c[i] >= 65 && (int) c[i] <= 90) { // 대문자인 경우
				ascNum = 65;
			} else if ((int) c[i] >= 97 && (int) c[i] <= 122) { // 소문자인 경우
				ascNum = 97;
			} else { // 띄어쓰기인 경우 그냥 띄어쓰기를 직접 삽입하고 다음 루프 진행
				answer += ' ';
				continue;
			}
			abs = Math.abs(ascNum - (int) c[i]); // 반대문자 전환용 차이값
			answer += (char) (ascNum + 25 - abs); // 반대문자 전환
		}

		return answer;
	}
}
