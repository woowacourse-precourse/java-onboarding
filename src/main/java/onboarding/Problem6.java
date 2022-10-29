package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    static HashMap<String, Set<String>> emailAndNicknameMap;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static void addNicknameSubstring(int index, String email, String nickname, String substring) {

        if (substring.length() >= 2) {
            Set<String> set = emailAndNicknameMap.getOrDefault(substring, new HashSet<>());
            set.add(email);
            emailAndNicknameMap.put(substring, set);
        }

        if(index >= nickname.length())
            return;

        addNicknameSubstring(index + 1, email, nickname, substring + nickname.charAt(index));


    }
}
