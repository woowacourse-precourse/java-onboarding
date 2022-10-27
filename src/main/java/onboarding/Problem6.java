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
			List<String> separatedNickname = separateNickname(nickname); // 두 글자로 분리된 닉네임 리스트

			for (int j = 0; j < separatedNickname.size(); j++) {

				String currentNickname = separatedNickname.get(j);

				if (listOfAll.containsKey(currentNickname)) { // 닉네임 리스트에 이미 똑같은 닉네임이 있는 경우
					listOfEmail.add(email); // 현재 차례의 이메일 주소를 리스트에 입력
					listOfEmail.add(forms.get(listOfAll.get(currentNickname)).get(0)); //닉네임 리스트에 있는 사람의 이메일 주소를 리스트에 입력
				}
				if (!listOfAll.containsKey(currentNickname)){ // 닉네임 리스트에 같은 닉네임이 없는 경우
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

}
