package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		List<String> nicknames = collectNicknames(forms);

		answer = makeDuplicateList(forms, nicknames);

		answer = processData(answer);
		return answer;
	}

	private static List collectNicknames(List<List<String>> data) {
		List<String> collection = new ArrayList<>();
		for (List target : data) {
			collection.add((String)target.get(1));
		}
		return collection;
	}

	private static List<String> makeDuplicateList(List<List<String>> data, List<String> nicknames) {
		List<String> temp = new ArrayList<>();

		for (List info : data) {
			String email = (String)info.get(0);
			String nickname = (String)info.get(1);
			nicknames.remove(nickname);
			if (checkNickname(nickname, nicknames)) {
				temp.add(email);
			}
			nicknames.add(nickname);
		}
		return temp;
	}

	private static boolean checkNickname(String name, List<String> comparedNames) {
		for (String target : comparedNames) {
			for (int i = 0; i < name.length() - 1; i++) {
				if (target.contains(name.substring(i, i + 2))) {
					return true;
				}
			}
		}
		return false;
	}

	private static List<String> processData(List<String> data) {
		Set<String> set = new HashSet<String>(data);
		data = new ArrayList<String>(set);
		Collections.sort(data);
		return data;
	}
}
