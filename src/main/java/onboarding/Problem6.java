package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		try {
			Database.validateData(forms);
			Database.setData(forms);
			List<String> answer = getEmailListByCheckNickname();
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return Collections.emptyList();
		}
	}

	static List<String> getEmailListByCheckNickname() {
		List<Integer> duplicatedIndexList = getDuplicatedIndex();
		List<String> duplicatedEmailList = getEmailListByIndexList(duplicatedIndexList);
		List<String> emailListAfterCheckDuplication = removeDuplicationOfEmailList(
			duplicatedEmailList);
		List<String> answer = sortEmailList(emailListAfterCheckDuplication);
		return answer;
	}

	static List<Integer> getDuplicatedIndex() {
		List<Integer> duplicatedIndex = new ArrayList<>();
		List<String> nameList = Database.getNameList();
		int nameCount = nameList.size();
		for (int i = 0; i < nameCount; i++) {
			String name = nameList.get(i);
			boolean isNameDuplicated = checkNameDuplication(name, i);
			if (isNameDuplicated) {
				duplicatedIndex.add(i);
			}
		}
		return duplicatedIndex;
	}

	static boolean checkNameDuplication(String name, int indexOfName) {
		List<String> nameSplitBy2 = splitNameBy2(name);
		boolean isDuplicated = false;
		for (int i = 0; i < nameSplitBy2.size(); i++) {
			String twoCharacters = nameSplitBy2.get(i);
			boolean isNameDuplicated = Database.checkDuplicationByTwoCharacters(twoCharacters,
				indexOfName);
			if (isNameDuplicated) {
				isDuplicated = true;
				break;
			}
		}
		return isDuplicated;
	}

	static List<String> splitNameBy2(String name) {
		List<String> nameSplitBy2 = new ArrayList<>();
		List<String> characterList = new ArrayList<>(Arrays.asList(name.split("")));
		int lengthOfName = characterList.size();
		for (int i = 0; i < lengthOfName - 1; i++) {
			String twoCharacters = characterList.get(i) + characterList.get(i + 1);
			nameSplitBy2.add(twoCharacters);
		}
		return nameSplitBy2;
	}

	static List<String> getEmailListByIndexList(List<Integer> duplicatedIndexList) {
		List<String> duplicatedEmailList = new ArrayList<>();
		List<String> emailList = Database.getEmailList();
		for (int index : duplicatedIndexList) {
			String email = emailList.get(index);
			duplicatedEmailList.add(email);
		}
		return duplicatedEmailList;
	}

	static List<String> sortEmailList(List<String> emailList) {
		List<String> sortedEmailList = emailList.stream().sorted().collect(
			Collectors.toList());
		return sortedEmailList;
	}

	static List<String> removeDuplicationOfEmailList(List<String> emailList) {
		Set set = new HashSet<>(emailList);
		List<String> emailListRemovedDuplication = new ArrayList<>(set);
		return emailListRemovedDuplication;
	}
}

class Database {

	static List<String> nameList = new ArrayList<>();
	static List<String> emailList = new ArrayList<>();

	static void setData(List<List<String>> forms) {
		nameList.clear();
		emailList.clear();
		setNameList(forms);
		setEmailList(forms);
	}

	static void setNameList(List<List<String>> forms) {
		forms.stream().forEach(form -> {
			String name = form.get((1));
			nameList.add(name);
		});
	}

	static void setEmailList(List<List<String>> forms) {
		forms.stream().forEach(form -> {
			emailList.add(form.get(0));
		});
	}

	static List<String> getNameList() {
		return nameList;
	}

	static List<String> getEmailList() {
		return emailList;
	}

	static boolean checkDuplicationByTwoCharacters(String twoCharacters, int indexOfName) {
		boolean isDuplicated = false;
		int nameCount = nameList.size();
		for (int i = 0; i < nameCount; i++) {
			if (i == indexOfName) {
				continue;
			}
			String name = nameList.get(i);
			boolean isContained = name.contains(twoCharacters);
			if (isContained) {
				isDuplicated = true;
				break;
			}
		}
		return isDuplicated;
	}

	static void validateData(List<List<String>> forms) throws Exception {
		validateLengthOfForms(forms);
		for (int i = 0; i < forms.size(); i++) {
			String name = forms.get(i).get(1);
			String email = forms.get(i).get(0);
			validateName(name);
			validateEmail(email);
		}
	}

	static void validateLengthOfForms(List<List<String>> forms) throws Exception {
		int lengthOfForms = forms.size();
		if (lengthOfForms < 1 || lengthOfForms > 10000) {
			throw new Exception("크루는 1명 이상 10000명 이하여야 합니다");
		}
	}

	static void validateName(String name) throws Exception {
		String pattern = "^[가-힣ㄱ-ㅎㅏ-ㅣ]{1,20}$";
		boolean isMatch = Pattern.matches(pattern, name);
		if (!isMatch) {
			throw new Exception("이름이 잘못되었습니다");
		}
	}

	static void validateEmail(String email) throws Exception {
		String pattern = "^[a-zA-Z0-9._%+-]{1,10}+@email.com$";
		boolean isMatch = Pattern.matches(pattern, email);
		if (!isMatch) {
			throw new Exception("이메일이 잘못되었습니다");
		}
	}
}