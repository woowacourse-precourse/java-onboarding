package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem6 기능 목록
 * 1. 전체 닉네임 리스트를 생성하기
 * 2. 중복 사용된 닉네임 리스트를 선언하기
 * 3. 중복 여부 판단을 위해 2글자 문자열 리스트 생성하기
 * 4. 기준이 될 닉네임을 제외한 닉네임리스트 생성하기
 * 5. 제외한 닉네임 리스트 내에 중복 문자열이 있는 지 확인 후 중복 사용된 닉네임리스트에 추가하기
 * 6. 중복 사용된 닉네임 리스트에서 중복 입력된 닉네임 제거하기
 * 7. 중복 사용된 닉네임의 이메일을 리스트에 추가하기
 * 8. 이메일 리스트를 오름차순 정렬하기
 * 9. 정렬된 이메일 리스트를 리턴하기
 */
public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		//닉네임 리스트 생성
		List<String> nicknameList = makeNicknameList(forms);
		// 중복 사용된 닉네임 리스트
		List<String> duplicateNicknameList = new ArrayList<>();

		for (List<String> list : forms) {
			// 중복 여부 판단 문자열 리스트 생성
			List<String> splitStringList = makeSplitStringList(list.get(1));
			// 기준 닉네임과 그 외 닉네임 분리
			List<String> ExtraNicknameList = makeExtraNicknameList(nicknameList, list.get(1));
			// 그 외 닉네임들 중복 여부 확인 후 중복 시 리스트 추가
			checkAndAddDuplicateNicknames(duplicateNicknameList, splitStringList, ExtraNicknameList);
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

	private static void checkAndAddDuplicateNicknames(List<String> duplicateNicknameList, List<String> splitStringList,
		List<String> ExtraNicknameList) {
		for (String extraNickname : ExtraNicknameList) {
			checkAndAddDuplicateNickname(duplicateNicknameList, splitStringList, extraNickname);
		}
	}

	private static void checkAndAddDuplicateNickname(List<String> duplicateNicknameList, List<String> splitStringList,
		String extraNickname) {
		for (String splitString : splitStringList) {
			// 중복 여부 확인
			addDuplicateNicknameList(duplicateNicknameList, extraNickname, splitString);
		}
	}

	private static void addDuplicateNicknameList(List<String> duplicateNicknameList, String extraNickname,
		String splitString) {
		if (isDuplicate(extraNickname, splitString))
			// 중복된 닉네임 리스트에 추가
			duplicateNicknameList.add(extraNickname);
	}

	private static void addDuplicateEmail(List<List<String>> forms, List<String> answer, String nickname) {
		for (List<String> list : forms) {
			addEmail(answer, nickname, list);
		}
	}

	private static void addEmail(List<String> answer, String nickname, List<String> list) {
		if (nickname.equals(list.get(1))) {
			answer.add(list.get(0));
		}
	}

	private static List<String> makeNicknameList(List<List<String>> forms) {
		List<String> nicknameList = new ArrayList<>();
		for (List<String> list : forms) {
			nicknameList.add(list.get(1));
		}
		return nicknameList;
	}

	private static List<String> makeExtraNicknameList(List<String> nicknameList, String nickname) {
		List<String> list = new ArrayList<>(nicknameList);
		list.remove(nickname);
		return list;
	}

	private static List<String> makeSplitStringList(String s) {
		List<String> splitStringList = new ArrayList<>();

		for (int i = 0; i < s.length() - 1; i++) {
			String subStr = s.substring(i, i + 2);
			splitStringList.add(subStr);
		}
		return splitStringList;
	}

	private static boolean isDuplicate(String nickname, String checkString) {
		return nickname.contains(checkString);
	}

	static List<String> removeListDuplication(List<String> list) {
		return list.stream().distinct().collect(Collectors.toList());
	}

}
