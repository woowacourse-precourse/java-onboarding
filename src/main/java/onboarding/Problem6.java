package onboarding;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static Set<String> toFragments(String word) {
        Set<String> fragments = new HashSet<>();
        for (int i = 1; i < word.length(); i++) {
            fragments.add(word.substring(i - 1, i + 1));
        }
        return fragments;
    }
    private static String getEmail(List<String> form) {
        return form.get(0);
    }
    private static String getNickname(List<String> form) {
        return form.get(1);
    }
}
