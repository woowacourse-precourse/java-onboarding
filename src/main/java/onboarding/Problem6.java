package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();

		HashSet<String> hashSet = new HashSet<>(); // 중복 제거를 위한 HashSet 사용

		for (int i = 0; i < forms.size(); i++) {
			String compareNickName = forms.get(i).get(1);
			for (int j = 0; j < compareNickName.length() - 2; j++) {
				for (int k = j + 1; k < compareNickName.length() - 1; k++) {
					String cutNickName = compareNickName.substring(j, k + 1); // 비교를 위한 닉네임에서 두 글자 이상의 문자를 뽑아내기

					for (int s = 0; s < forms.size(); s++) { // 뽑아낸 두 글자 이상의 문자를 기존의 문자와 비교
						String originalNickName = forms.get(s).get(1);
						if (originalNickName.contains(cutNickName) && originalNickName != compareNickName) {
							hashSet.add(forms.get(s).get(0));
							hashSet.add(forms.get(i).get(0));
						}
					}
				}

			}
		}

		ArrayList<String> sort = new ArrayList<>(hashSet);
		Collections.sort(sort);

		for (String email : hashSet) {
			answer.add(email);
		}

		return answer;
	}

}
