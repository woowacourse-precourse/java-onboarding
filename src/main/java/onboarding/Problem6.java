package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerCandidate = new HashSet<>();

        findContinuousTwoChar(forms, answerCandidate);

        List<String> answer = new ArrayList<>(answerCandidate);

        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    private static void findContinuousTwoChar(List<List<String>> forms, Set<String> answerCandidate) {
        for (int i = 0; i < forms.size(); ++i) {
            String nickName = forms.get(i).get(1);

            for (int j = 0; j < nickName.length() - 1; ++j) {
                String twoConsecutiveLetters = nickName.substring(j, j + 2);

                for (int k = i + 1; k < forms.size(); ++k) {
                    String nickNameComparator = forms.get(k).get(1);

                    if (nickNameComparator.contains(twoConsecutiveLetters)) {
                        answerCandidate.add(forms.get(i).get(0));
                        answerCandidate.add(forms.get(k).get(0));

                        break;
                    }
                }
            }
        }
    }
}