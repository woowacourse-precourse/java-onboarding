package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
	private static class ValidationInformation {
		public static boolean isOverlappedName(List<String> dividedName, List<String> crew) {
			String crewName = crew.get(1);
			for (int i = 0; i < dividedName.size(); i++) {
				if (crewName.equals(dividedName.get(0))) {
					return false;
				}
				if (crewName.contains(dividedName.get(i))) {
					return true;
				}
			}
			return false;
		}

		public static boolean isValidEmail(List<String> crew) {
			String crewEmail = crew.get(0);
			String domain = crewEmail.split("@")[1];
			if ((crewEmail.length() < 1) || (crewEmail.length() >= 20)) {
				return false;
			}
			if (!domain.equals("email.com")) {
				return false;
			}
			return true;
		}

		public static boolean isValidNickName(List<String> crew) {
			String crewNickName = crew.get(1);
			if ((crewNickName.length() < 1) || (crewNickName.length() >= 20)) {
				return false;
			}
			if (!crewNickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
				return false;
			}
			return true;
		}

		public static List<List<String>> removeInvalidCrew(List<List<String>> forms) {
			List<List<String>> validForms = forms.stream()
				.filter(i -> (isValidEmail(i)) && (isValidNickName(i)))
				.collect(Collectors.toList());
			return validForms;
		}
	}

	static class HandlingList {
		public static List<String> removeSamethings(List<String> list) {
			List<String> newlList = list.stream()
				.distinct()
				.collect(Collectors.toList());
			return newlList;
		}

		public static List<String> sortList(List<String> list) {
			Collections.sort(list);
			return list;
		}

		public static void copyList(List<String> target, List<String> object) {
			for (int i = 0; i < object.size(); i++) {
				target.add(object.get(i));
			}
		}
	}

	private static class HandlingInformation {
		public static List<String> divideIntoTwoWords(List<String> crew) {
			List<String> dividedName = new ArrayList<String>();
			String name = crew.get(1);
			String newWord = "";
			dividedName.add(name);
			for (int i = 0; i < name.length() - 1; i++) {
				newWord = Character.toString(name.charAt(i)) + Character.toString(name.charAt(i + 1));
				dividedName.add(newWord);
			}
			return dividedName;
		}
	}

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<String>();
		forms = ValidationInformation.removeInvalidCrew(forms);
		for (int i = 0; i < forms.size(); i++) {
			List<String> dividedNickNameList = HandlingInformation.divideIntoTwoWords(forms.get(i));
			List<String> list = forms.stream()
				.filter(crewInfo -> ValidationInformation.isOverlappedName(dividedNickNameList, crewInfo))
				.map(crewInfo -> crewInfo.get(0))
				.collect(Collectors.toList());
			HandlingList.copyList(answer, list);
		}
		answer = HandlingList.removeSamethings(answer);
		answer = HandlingList.sortList(answer);
		return answer;
	}
}
