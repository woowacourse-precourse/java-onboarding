package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
		Set<String> deleteDuplicate = new HashSet<>();

		for(int targetIdx = 0; targetIdx < forms.size(); targetIdx++) {

			for(int compareIdx = targetIdx + 1; compareIdx < forms.size(); compareIdx++) {

				String target = forms.get(targetIdx).get(1);
				String compare = forms.get(compareIdx).get(1);
				String targetEmail = forms.get(targetIdx).get(0);
				String compareEmail = forms.get(compareIdx).get(0);

				if(dupleCheck(target, compare)) {
					deleteDuplicate.add(targetEmail);
					deleteDuplicate.add(compareEmail);
					break;
				}
			}

		}
		answer = new ArrayList<>(deleteDuplicate);
		Collections.sort(answer);

		return answer;
	}

	public static boolean dupleCheck(String target, String compare) {
		char[] targetWord = target.toCharArray();

		for(int i = 0; i <targetWord.length - 1; i++) {
			if(compare.contains("" + targetWord[i] + targetWord[i + 1])) {
				return true;
			}
		}

		return false;
	}

}
