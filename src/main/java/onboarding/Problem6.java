package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> splitTwoLetter(String nickname) {
        List<String> twoLetterNicknames = new ArrayList<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            twoLetterNicknames.add(twoLetterNickname);
        }

        return twoLetterNicknames;
    }
}
