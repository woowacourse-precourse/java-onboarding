package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> splitString(String nickname) {
        List<String> fragment = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++)
            fragment.add(nickname.substring(i, i + 2));
        return fragment;
    }

    public static boolean searchSameSeq(String nickname, List<String> fragments) {
        for (String frag : fragments)
            if (nickname.contains(frag)) return true;
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerSet = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            List<String> form = forms.get(i);
            String nickname = form.get(1);
            List<String> fragments = splitString(nickname);
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> nextForm = forms.get(j);
                String nicknameToCompare = nextForm.get(1);
                if (searchSameSeq(nicknameToCompare, fragments)) {
                    answerSet.add(form.get(0));
                    answerSet.add(nextForm.get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(answerSet);
        answer.sort(null);
        return answer;
    }
}
