package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	private static Set<String> checkNicknameIsOverlap(List<String> nickname, List<String> checkNickname) {
		Set<String> emailSet = new HashSet<>();
		String nicknameString = nickname.get(1);
		String checkNicknameString = checkNickname.get(1);
		for (int i = 0; i < nicknameString.length()-1; i++) {
			String tokenNickname = nicknameString.substring(i , i + 2);
			if (checkNicknameString.contains(tokenNickname)) {
				emailSet.add(nickname.get(0));
				emailSet.add(checkNickname.get(0));
				break;
			}
		}

		return emailSet;
	}
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> emailSet = new HashSet<>();

		for (int i = 0; i < forms.size(); i++) {
			for (int j = i + 1; j < forms.size(); j++) {
				emailSet.addAll(checkNicknameIsOverlap(forms.get(i), forms.get(j)));
			}
		}

		answer.addAll(emailSet);
		Collections.sort(answer);
        return answer;
    }
}
