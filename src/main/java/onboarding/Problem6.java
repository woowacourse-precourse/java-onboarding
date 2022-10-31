package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static String getTwoDigitName(String nickname, int startIdx) {
        return nickname.substring(startIdx, startIdx + 2);
    }
}
