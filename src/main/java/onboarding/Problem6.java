package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

	public static List<Set<String>> createAllCrewNicknameTokens(List<List<String>> forms, Map<String, Integer> allCrewNicknameTokens) {
		String crewNickname = "";
		Map<String, Integer> tokenizedNickname;
		List<Set<String>> allCrewNicknameTokenList = new ArrayList<>();

		for (List<String> crew : forms) {
			crewNickname = crew.get(1);
			tokenizedNickname = nicknameTokenizer(crewNickname);
			allCrewNicknameTokenList.add(tokenizedNickname.keySet());
			allCrewNicknameTokens = mapMerge(allCrewNicknameTokens, tokenizedNickname);
		}

		return allCrewNicknameTokenList;
	}

	public static Map<String, Integer> nicknameTokenizer(String crewNickname){
		Map<String, Integer> nicknameTokens = new HashMap<>();
		String nicknameToken = "";

		for(int i = 0; i < crewNickname.length()-1; i++) {
			nicknameToken = crewNickname.substring(i,i + 2);
			nicknameTokens.put(nicknameToken, 1);
		}

		return nicknameTokens;
	}

	public static Map<String, Integer> deleteNotDuplicatedToken(Map<String, Integer> allCrewNicknameTokens) {
		allCrewNicknameTokens.values().removeAll(Arrays.asList(1));
		return allCrewNicknameTokens;
	}

	public static Map<String, Integer> mapMerge(Map<String, Integer> map1, Map<String, Integer> map2) {
		map2.forEach((key, value) -> map1.merge(key, value, (value1, value2) -> value1 + value2));
		return map1;
	}

    public static List<String> solution(List<List<String>> forms) {
		// List<String> answer = List.of("answer");
		List<String> answer = new ArrayList<>();
		Map<String, Integer> allCrewNicknameTokens = new HashMap<>();

		List<Set<String>> allCrewTokenList = createAllCrewNicknameTokens(forms, allCrewNicknameTokens);
		allCrewNicknameTokens = deleteNotDuplicatedToken(allCrewNicknameTokens);

        return answer;
    }
}
