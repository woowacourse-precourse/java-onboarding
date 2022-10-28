package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

	public static Map<String, Integer> nicknameTokenizer(String crewNickname){
		Map<String, Integer> nicknameTokens = new HashMap<>();
		String nicknameToken = "";

		for(int i = 0; i < crewNickname.length()-1; i++) {
			nicknameToken = crewNickname.substring(i,i + 2);
			nicknameTokens.put(nicknameToken, 1);
		}

		return nicknameTokens;
	}

    public static List<String> solution(List<List<String>> forms) {
		List<String> answer = List.of("answer");
        return answer;
    }
}
