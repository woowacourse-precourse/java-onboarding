package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> answerSet = new HashSet<>();

        for (int i=0 ; i<forms.size() ; i++) {
            String nickname = forms.get(i).get(1);
            Set<String> subNickname = new HashSet<>();
            for (int j=0 ; j<nickname.length()-1 ; j++) {
                subNickname.add(nickname.substring(j, j+2));
            }

            for (int j=i+1 ; j<forms.size() ; j++) {
                for (String subWord : subNickname) {
                    if (forms.get(j).get(1).contains(subWord)) {
                        answerSet.add(forms.get(i).get(0));
                        answerSet.add(forms.get(j).get(0));
                    }
                }
            }
        }

        answer = new ArrayList<>(answerSet);
        Collections.sort(answer);

        return answer;
    }
}
