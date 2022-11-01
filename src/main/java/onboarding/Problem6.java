package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Problem6 p6 = new Problem6();
        return answer;
    }

    private List<String> stringTokens(String word) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < word.length() - 1; i++) {
            String temp = Character.toString(word.charAt(i)) + Character.toString(word.charAt(i + 1));
            result.add(temp);
        }
        return result;
    }
}
