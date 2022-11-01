package onboarding;

import java.util.*;

public class Problem6 {
	private static HashSet<String> emails;
	private static Hashtable<String, Integer> words;
	private static void fillSetEach(List<String> form) {
		String nickname = form.get(1);
		String word;
		int last;
		int newValue;

		last = nickname.length();
		if (last == 1)
			return;
		last--;
		for (int i = 0; i < last; i++) {
			word = nickname.substring(i, i + 2);
			newValue = words.getOrDefault(word, 0) + 1;
			words.put(word, newValue);
		}
	}
	private static void fillSetAll(List<List<String>> forms) {
		forms.forEach(Problem6::fillSetEach);
	}
	private static void addEmailIfContainKey(String email, boolean flag) {
		if (flag)
			emails.add(email);
	}
	private static void checkIfContainKey(String email, String nickname) {
		Set<String> keySet = words.keySet();
		boolean isContained;
		boolean isOver1;

		for (String key : keySet) {
			isContained = nickname.contains(key);
			isOver1 = words.get(key) > 1;
			addEmailIfContainKey(email, isContained && isOver1);
		}
	}
	private static void findDuplicated(List<List<String>> forms) {
		String email;
		String nickName;

		for (List<String> form : forms) {
			email = form.get(0);
			nickName = form.get(1);
			checkIfContainKey(email, nickName);
		}
	}
	public static List<String> solution(List<List<String>> forms) {
		emails = new HashSet<>();
		words = new Hashtable<>();
		List<String> answer;

		fillSetAll(forms);
		findDuplicated(forms);
		answer = new ArrayList<>(emails);
		Collections.sort(answer);
		return (answer);
	}
}
