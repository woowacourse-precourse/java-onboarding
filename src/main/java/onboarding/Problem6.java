package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isOverlap(String nickname, String comparisonNickname) {
        for (int i = 1; i < nickname.length(); i++) {
            String nicknameToken = nickname.substring(i - 1, i + 1);

            if (comparisonNickname.contains(nicknameToken)) {
                return true;
            }
        }

        return false;
    }
}
