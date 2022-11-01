package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class StringComparator implements Comparator<String> {
	@Override public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}


public class Problem6 {
	// 닉네임 글자가 겹치는 사람들의 이메일을 오름차순으로 정렬해서 반환한다.
	public static List<String> solution(List<List<String>> forms) {
		List<String> subPatterns;
		HashSet<String> overlappingEmail = new HashSet<>();

		for (List<String> pattern : forms) {
			String nameForPattern = pattern.get(1);
			// 한명의 닉네임에 대한 2글자의 부분 문자열을 만든다.
			subPatterns = makeSubString(pattern);
			// 겹치는 글자를 가진 사람의 이메일을 저장한다.
			overlappingEmail.addAll(matchSubPatternsToParent(nameForPattern, subPatterns, forms));
		}
		// 이메일을 글자의 오름차순으로 정렬한다.
		List<String> result = sortForResult(overlappingEmail);
		return result;
	}

	// 기능 2. 부분문자열들을 가지고 중복을 확인하고 이메일을 저장한다.
	private static HashSet<String> matchSubPatternsToParent(String nameForPattern,
		List<String> subPatterns, List<List<String>> forms) {
		HashSet<String> overlappingEmailSet = new HashSet<>();
		// 리스트를 순회하면서 부분문자열과 매칭해본다.
		for (List<String> parent : forms) {
			// 문자열이 매칭이 되었다면 email이 나올 것이고 저장한다.
			String parentEmail = findSubPatternInParent(nameForPattern, parent, subPatterns);
			if (parentEmail != null) {
				overlappingEmailSet.add(parentEmail);
			}
		}

		return overlappingEmailSet;
	}

	// 기능 1. 한 사람의 닉네임에서 2글자의 부분문자열을 모두 찾아낸다.
	private static List<String> makeSubString(List<String> str) {
		List<String> subStrings = new ArrayList<>();
		String strName = str.get(1);

		for (int i = 0; i < strName.length() - 1; i++) {
			String subPattern = strName.substring(i, i + 2);
			subStrings.add(subPattern);
		}

		return subStrings;
	}

	// 기능 3. 부분문자열이 닉네임에 포함되어있는지 확인하고 있다면 이메일을 반환한다.
	private static String findSubPatternInParent(String nameForPattern, List<String> parent,
		List<String> subPatterns) {
		String parentEmail = parent.get(0);
		String parentName = parent.get(1);

		for (String subPattern : subPatterns) {
			// 만약 본인이 아닌 다른 사람의 닉네임에 부분 문자열이 있는 경우 이메일을 반환
			if (!nameForPattern.equals(parentName) && parentName.contains(subPattern)) {
				return parentEmail;
			}
		}

		return null;
	}

	// 기능 4. 문자열을 오름차순으로 정렬한다.
	private static List<String> sortForResult(HashSet<String> overlappingEmail) {
		List<String> result = new ArrayList<>(overlappingEmail);
		result.sort(new StringComparator());
		return result;
	}
}
