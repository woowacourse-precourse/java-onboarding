package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static List<String> searchDuplicate(List<List<String>> forms) {
        HashMap<String, Integer> allNicknameElements = new HashMap<String, Integer>();
        String nickname;
        for (int i = 0; i < forms.size(); i++) {
            HashSet<String> nicknameElements = new HashSet<>();
            nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                nicknameElements.add(nickname.substring(i, i+2));
            }
        }
    }
}
