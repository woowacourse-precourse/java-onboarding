package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return sortResult(returnResult(forms));
    }

    private static List<String> sortResult(List<String> result) {
        result.sort(Comparator.naturalOrder());
        return result;
    }

    private static List<String> returnResult(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        for (List<String> emailAndNickname : forms) {
            if (checkSimilarityInCrewList(emailAndNickname.get(1), forms) && !result.contains(
                emailAndNickname.get(0))) {
                result.add(emailAndNickname.get(0));
            }
        }
        return result;
    }
    private static boolean checkSimilarityInCrewList(String nickname, List<List<String>> forms) {
        for (List<String> emailAndNickname : forms) {
            if (!nickname.equals(emailAndNickname.get(1)) && checkSimilarity(nickname, emailAndNickname.get(1))) {
                return true;
            }
        }
        return false;
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
