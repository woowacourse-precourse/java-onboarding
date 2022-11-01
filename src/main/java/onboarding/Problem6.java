package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem6 {
    private static List<String> selectTwoLetters(String nickname) {
        List<String> twoLettersList = new LinkedList<>();
        for (int i = 0; i < nickname.length(); i++) {
            String twoLetters = nickname.substring(i-1, i+1);
            twoLettersList.add(twoLetters);
        }
        return twoLettersList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
