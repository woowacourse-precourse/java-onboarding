package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> patternsFromNickName = makePatternsFromNickName(forms);

        return answer;
    }

    public static Set<String> makePatternsFromNickName(List<List<String>> forms) {
        Set<String> patterns = new HashSet<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1; i++) {
                String pattern = nickname.substring(i, i + 2);
                patterns.add(pattern);
            }
            patterns.add(nickname);
        }

        return patterns;
    }
}
