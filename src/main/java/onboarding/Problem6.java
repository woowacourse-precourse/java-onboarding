package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		//닉네임 리스트 생성
		List<String> nicknameList = makeNicknameList(forms);
		// 중복된 닉네임 리스트
		List<String> duplicateNicknameList = new ArrayList<>();

		for (List<String> list : forms) {
			// 중복 여부 판단 문자열 리스트 생성
			List<String> splitStringList = makeSplitStringList(list.get(1));
			List<String> ExtraNicknameList = makeExtraNicknameList(nicknameList, list.get(1));
			for (String extraNickname : ExtraNicknameList) {
				checkDuplicate(duplicateNicknameList, splitStringList, extraNickname);
			}
		}

		// 리스트 중복 제거
		List<String> removeNicknameDuplicationList = removeListDuplication(duplicateNicknameList);

		// 중복된 닉네임의 이메일을 리스트에 추가
		List<String> answer = new ArrayList<>();
		for (String nickname : removeNicknameDuplicationList) {
			addDuplicateEmail(forms, answer, nickname);
		}
		// 리스트 오름차순 정렬  (sort 함수)
		Collections.sort(answer);
		return answer;
	}

	private static void checkDuplicate(List<String> duplicateNicknameList, List<String> splitStringList,
		String extraNickname) {
		for (String splitString : splitStringList) {
			// 중복된 닉네임 리스트에 추가
			addDuplicateNickname(duplicateNicknameList, extraNickname, splitString);
		}
	}

	private static void addDuplicateNickname(List<String> duplicateNicknameList, String extraNickname,
		String splitString) {
		// 중복 여부 확인
		if (isDuplicate(extraNickname, splitString))
			duplicateNicknameList.add(extraNickname);
	}

	private static void addDuplicateEmail(List<List<String>> forms, List<String> answer, String nickname) {
		for (List<String> list : forms) {
			if (nickname.equals(list.get(1))) {
				answer.add(list.get(0));
			}
		}
	}

	static List<String> makeNicknameList(List<List<String>> forms) {
		List<String> nicknameList = new ArrayList<>();
		for (List<String> list : forms) {
			nicknameList.add(list.get(1));
		}
		return nicknameList;
	}

	static List<String> makeExtraNicknameList(List<String> nicknameList, String nickname) {
		List<String> list = new ArrayList<>(nicknameList);
		list.remove(nickname);
		return list;
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
