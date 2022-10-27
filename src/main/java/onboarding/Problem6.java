package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");

		answer = findDuplicateNickname(forms); // 중복닉네임을 가진 이메일 리스트를 answer에 입력
		answer = sortEmailList(answer); // 중복 제거 및 오름차순으로 정렬

		return answer;
	}


	/**
	 * 기능1 각 닉네임을 두 글자로 분리하는 기능 ex) 제이엠 -> 제이, 이엠
	 */
	public static List<String> separateNickname(String nickname) {

		List<String> twoLetters = new ArrayList<>();
		for (int i = 0; i < nickname.length() - 1; i++) {
			twoLetters.add(nickname.substring(i, i + 2));
		}

		return twoLetters;
	}

	/**
	 * 기능 2 HashMap을 통해서 중복된 닉네임을 작성한 이메일 목록을 찾는 기능
	 */

	public static List<String> findDuplicateNickname(List<List<String>> forms) {

		HashMap<String, Integer> listOfAll = new HashMap<>(); // 두 글자로 분리된 이름과 인덱스를 저장할 해쉬맵
		List<String> listOfEmail = new ArrayList<>(); // 이메일을 저장할 리스트

		for (int i = 0; i < forms.size(); i++) {

			String nickname = forms.get(i).get(1);
			String email = forms.get(i).get(0);

			if(!useKoreanNickname(nickname)) // 닉네임이 한글이 아닐 시 다음 forms로
				continue;

			List<String> separatedNickname = separateNickname(nickname); // 두 글자로 분리된 닉네임 리스트

			for (int j = 0; j < separatedNickname.size(); j++) {

				String currentNickname = separatedNickname.get(j);

				if (listOfAll.containsKey(currentNickname)) { // 닉네임 리스트에 이미 똑같은 닉네임이 있는 경우
					if(emailDomainValidation(email))
						listOfEmail.add(email); // 현재 차례의 이메일 주소를 리스트에 입력
					if(emailDomainValidation(forms.get(listOfAll.get(currentNickname)).get(0)))
						listOfEmail.add(forms.get(listOfAll.get(currentNickname)).get(0)); //닉네임 리스트에 있는 사람의 이메일 주소를 리스트에 입력
				}
				if (!listOfAll.containsKey(currentNickname)) { // 닉네임 리스트에 같은 닉네임이 없는 경우
					listOfAll.put(currentNickname, i); // 닉네임 리스트에 닉네임과 forms의 인덱스를 입력
				}
			}
		}

		return listOfEmail;
	}


	/**
	 * 기능 3 이메일 목록을 중복 제거 및 오름차순으로 정렬
	 */
	public static List<String> sortEmailList(List<String> listOfEmail) {

		return listOfEmail.stream().sorted().distinct().collect(Collectors.toList());
	}

	/**
	 * 기능 4 이메일 도메인이 email.com이 맞는지 검증
	 */
	public static boolean emailDomainValidation(String email) {

		String properDomain = "@email.com";

		if (email.substring(email.length() - 10, email.length()).equals(properDomain)) {
			return true;
		}

		return false;
	}

	/**
	 * 기능 5 닉네임이 한글만 있는지 검증
	 */
	public static boolean useKoreanNickname(String nickname) {
		if(nickname.matches("^[ㄱ-ㅎ가-힣]*$"))
			return true;
		return false;
	}
}
