package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean checkSimilarity(String nickname, String target) {
        for (int i = 0; i < nickname.length()-1; i++) {
            if (target.contains(returnBiliteralSubstring(nickname, i))) {
                return true;
            }
        }
        return false;
    }
    private static String returnBiliteralSubstring(String nickname, int index) {
        return nickname.substring(index, index+2);
    }
}
