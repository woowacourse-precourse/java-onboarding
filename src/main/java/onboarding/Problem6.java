package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

	public static void createAllCrewNicknameTokens(List<Set<String>> EachCrewTokenList,
												   Map<String, Integer> allCrewNicknameTokens) {
		for (Set<String> crew : EachCrewTokenList) {
			crew.stream().forEach(s -> allCrewNicknameTokens.put(s, allCrewNicknameTokens.getOrDefault(s, 0) + 1));
		}
	}

	public static List<Set<String>> createEachCrewNicknameTokenList(List<List<String>> forms) {
		String crewNickname = "";
		Set<String> tokenizedNickname;
		List<Set<String>> allCrewNicknameTokenList = new ArrayList<>();

		for (List<String> crew : forms) {
			crewNickname = crew.get(1);
			tokenizedNickname = nicknameTokenizer(crewNickname);
			allCrewNicknameTokenList.add(tokenizedNickname);
		}

		return allCrewNicknameTokenList;
	}

	public static Set<String> nicknameTokenizer(String crewNickname) {
		Set<String> nicknameTokens = new HashSet<>();
		String nicknameToken = "";

		for (int i = 0; i < crewNickname.length() - 1; i++) {
			nicknameToken = crewNickname.substring(i, i + 2);
			nicknameTokens.add(nicknameToken);
		}

		return nicknameTokens;
	}

	public static void deleteNotDuplicatedToken(Map<String, Integer> allCrewNicknameTokens) {
		allCrewNicknameTokens.values().removeAll(Arrays.asList(1));
	}

	public static List<String> solution(List<List<String>> forms) {
		// List<String> answer = List.of("answer");
		List<String> answer = new ArrayList<>();
		List<Set<String>> EachCrewTokenList;
		Map<String, Integer> allCrewNicknameTokens = new HashMap<>();

		EachCrewTokenList = createEachCrewNicknameTokenList(forms);
		createAllCrewNicknameTokens(EachCrewTokenList, allCrewNicknameTokens);
		deleteNotDuplicatedToken(allCrewNicknameTokens);

		for (int i = 0; i < EachCrewTokenList.size(); i++) {
			Map<String, Integer> finalNicknamesTokens = allCrewNicknameTokens;

			if (EachCrewTokenList.get(i).stream().anyMatch(finalNicknamesTokens::containsKey)) {
				answer.add(forms.get(i).get(0));
			}
		}

		answer = answer.stream().distinct().sorted().collect(Collectors.toList());

		return answer;
	}
}
