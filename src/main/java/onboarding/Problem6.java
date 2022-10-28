package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> getWords(String nick) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nick.length() - 1; i++) {
            result.add(nick.substring(i, i + 2));
        }

        return result;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
