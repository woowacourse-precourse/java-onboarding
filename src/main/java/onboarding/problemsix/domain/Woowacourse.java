package onboarding.problemsix.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Woowacourse {

	private HashMap<String, String> morphemeMap = new HashMap<>();
	private HashSet<String> emailSet = new HashSet<>();

	public void saveForms(List<List<String>> forms) {
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);

			saveEmail(email, nickname);
		}
	}

	public List<String> getEmailList() {

		List<String> emailList = new ArrayList<>(emailSet);
		Collections.sort(emailList);

		return emailList;
	}

	private void saveEmail(String email, String nickname) {
		for (int start = 0; start < nickname.length() - 1; start++) {
			for (int length = 2; length <= nickname.length() && start + length <= nickname.length(); length++) {
				String morpheme = nickname.substring(start, start + length);

				if (morphemeMap.containsKey(morpheme)) {
					emailSet.add(morphemeMap.get(morpheme));
					emailSet.add(email);
				} else {
					morphemeMap.put(morpheme, email);
				}
			}
		}
	}

}
