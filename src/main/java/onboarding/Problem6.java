package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for(int j = 0; j < nickname.length() - 1; j++) {
                for(int k = i + 1; k < forms.size(); k++) {
                    if(answer.contains(forms.get(k).get(0))) continue;
                    if(forms.get(k).get(1).contains(nickname.substring(j, j + 2))) {
                        if(!answer.contains(forms.get(i).get(0))) answer.add(forms.get(i).get(0));
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
