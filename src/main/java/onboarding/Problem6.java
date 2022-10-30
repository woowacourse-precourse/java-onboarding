package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int index = 0; index < forms.size(); index++) {
            String nickname = forms.get(index).get(1);
            Set<String> patternsFromNickName = makePatternsFromNickName(nickname);
        }

        return answer;
    }

    public static Set<String> makePatternsFromNickName(String nickname) {
        Set<String> patterns = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String pattern = nickname.substring(i, i + 2);
            patterns.add(pattern);
        }
        patterns.add(nickname);

        return patterns;
    }
}
