package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        TreeSet<String> answerSet = new TreeSet<>();
        return answer;
    }

    public static boolean findSimilarNickname(String nickname, String comparedNickname) {
        for (int i = 0; i < comparedNickname.length() - 1; i++) {
            if (nickname.contains(comparedNickname.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

}
