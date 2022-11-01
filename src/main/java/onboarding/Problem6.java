package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        TreeSet<String> answerSet = new TreeSet<>();
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            for (int j = 0; j < forms.size(); j++) {
                if (i == j) continue;
                String comparedNickname = forms.get(j).get(1);
                String comparedEmail = forms.get(j).get(0);

                if (findSimilarNickname(nickname, comparedNickname)) {
                    answerSet.add(email);
                    answerSet.add(comparedEmail);
                }
            }
        }
        for (String email : answerSet) {
            answer.add(email);
        }

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
