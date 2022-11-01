package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		validateForms(forms);

		List<String> answer = new ArrayList<>();
		List<String> duplicateTwoLetterList = getDuplicateTwoLetterList(getTwoLetterList(forms));

		for(List<String> form : forms) {
			validateEmail(form.get(0));
			validateNickname(form.get(1));
			if(hasDuplicateTwoLetter(form.get(1), duplicateTwoLetterList)) answer.add(form.get(0));
		}

		return answer.stream()
				.distinct() // 중복 제거
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
	}

	/**
	 * list에 대한 유효성 검사
	 * @param forms
	 */
	public static void validateForms(List<List<String>> forms) {
		if(forms.size() < 1 || forms.size() > 10000) throw new IllegalArgumentException();
	}

	/**
	 * email에 대한 유효성 검사
	 * @param email
	 */
	public static void validateEmail(String email) {
		if(!email.contains("@email.com")) throw new IllegalArgumentException();
		if(email.length() < 11 || email.length() >= 20) throw new IllegalArgumentException();
	}

	/**
	 * 닉네임에 대한 유효성 검사
	 * @param nickname
	 * @return
	 */
	public static boolean validateNickname(String nickname) {
		if(!nickname.matches("^[가-힣]*$")) throw new IllegalArgumentException();
		if(nickname.length() < 1 || nickname.length() >= 20) throw new IllegalArgumentException();
		return true;
	}

	/**
	 * 주어진 문자열을 2글자로 자른 문자열을 주어진 리스트에 담는다.
	 * @param nickname
	 * @param twoLetterList 문자열을 담는 리스트
	 */
	public static void addTwoLetter(String nickname, List<String> twoLetterList) {
		String[] nicknameArray = nickname.split("");

		for(int i = 0; i < nicknameArray.length - 1; i++){
			twoLetterList.add(nicknameArray[i] + nicknameArray[i+1]);
		}
	}

	/**
	 * 모든 크루들의 닉네임을 2글자로 자른 문자열들을 담아 리스트로 반환한다.
	 * @param forms
	 * @return
	 */
	public static List<String> getTwoLetterList(List<List<String>> forms) {
		List<String> twoLetterList = new ArrayList<>();

		for (List<String> form : forms) {
			addTwoLetter(form.get(1), twoLetterList);
		}

		return twoLetterList;
	}

	/**
	 * 크루들의 닉네임을 2글자로 자른 문자열들을 담은 리스트 중 중복이 2번 이상 되는 문자열들을 새로운 리스트에 담아 반환한다.
	 * @param twoLetterList 2글자 리스트 : 크루들의 닉네임을 2글자로 자른 문자열들을 담은 리스트
	 * @return
	 */
	public static List<String> getDuplicateTwoLetterList(List<String> twoLetterList) {
		return twoLetterList.stream()
				.filter(x -> Collections.frequency(twoLetterList, x) > 1)
				.collect(Collectors.toList());
	}

	/**
	 * 주어진 nickname이 중복 2글자 리스트의 문자열들을 포함하는 지 판단한다.
	 * @param nickname
	 * @param duplicateTwoLetterList 중복 2글자 리스트 : 크루들의 닉네임을 2글자로 자른 후, 중복이 2번 이상 되는 문자열을 담은 리스트
	 * @return
	 */
	public static boolean hasDuplicateTwoLetter(String nickname, List<String> duplicateTwoLetterList) {
		for (String twoLetter : duplicateTwoLetterList) {
			if (nickname.contains(twoLetter) == true) {
				return true;
			}
		}
		return false;
	}
}
