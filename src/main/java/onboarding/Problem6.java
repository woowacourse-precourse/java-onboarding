package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		// 중복 여부 판단 문자열 선정 (이중 for문)
		// 중복 여부 확인 (contain 함수)
		// 중복된 닉네임의 이메일을 리스트에 추가
		// 리스트 오름차순 정렬  (sort 함수)
		// 리스트 중복 제거 (set 함수 이용)
		List<String> answer = List.of("answer");
		return answer;
	}

	static List<String> removeListDuplication(List<String> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}

	static void splitCheckString(String s) {
		for (int i = 0; i <= s.length(); i++) {
			for (int j = i+2; j <= s.length(); j++) {
				String subStr = s.substring(i, j);
				System.out.print(subStr + " ");
			}
		}
	}

	static boolean isDuplicate(String nickname, String checkString) {
			return nickname.contains(checkString);
	}
}
