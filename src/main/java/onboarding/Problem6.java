package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		// 닉네임 리스트 생성
		// 중복 여부 판단 문자열 선정 (이중 for문)
		// 중복 여부 확인 (contain 함수)
		// 중복된 닉네임의 이메일을 리스트에 추가
		// 리스트 중복 제거 (set 함수 이용)
		// 리스트 오름차순 정렬  (sort 함수)
		List<String> answer = List.of("answer");
		return answer;
	}

	static List<String> makeNicknameList(List<List<String>> forms) {
		List<String> nicknameList = new ArrayList<>();
		for (List<String> list : forms) {
			nicknameList.add(list.get(1));
		}
		return nicknameList;
	}

	static List<String> makeSplitStringList(String s) {
		List<String> splitStringList = new ArrayList<>();

		for (int i = 0; i <= s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j++) {
				String subStr = s.substring(i, j);
				splitStringList.add(subStr);
			}
		}
		return splitStringList;
	}

	static boolean isDuplicate(String nickname, String checkString) {
		return nickname.contains(checkString);
	}

	static List<String> removeListDuplication(List<String> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}
}
