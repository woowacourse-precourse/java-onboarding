package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int k = 0; k < nickname.length() - 1; k++){
                boolean flag = false;
                String substr = nickname.substring(k, k+2);
                for (int j = 0; j < forms.size(); j++){
                    if (i == j) continue;
                    else if (forms.get(j).get(1).contains(substr)){
                        answer.add(forms.get(i).get(0));
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
