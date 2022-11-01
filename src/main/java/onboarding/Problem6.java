package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = i + 1; j < forms.size(); j++) {
                String comparedEmail = forms.get(j).get(0);
                String comparedNickname = forms.get(j).get(1);
            }
        }
        return answer;
    }
}