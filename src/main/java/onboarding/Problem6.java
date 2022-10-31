package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                String tmp = String.valueOf(nickname.charAt(j)) + nickname.charAt(j + 1);
            }
        }
        List<String> answer = List.of("answer");
        return answer;
    }

}
