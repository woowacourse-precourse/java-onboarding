package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++){
            String checkName = forms.get(i).get(1);
            for(int j = 0; j < checkName.length() - 1; j++){
                checkName = checkName.substring(j,j+2);
                for(int k = 0; k < forms.size(); k++){
                    if(k == i) continue;
                    if(forms.get(k).get(1).contains(checkName)){
                        if(!answer.contains(forms.get(k).get(0)))
                            answer.add(forms.get(k).get(0));
                    }
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
