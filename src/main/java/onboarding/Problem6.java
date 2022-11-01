package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i ++){
            for(int j = 0; j < forms.get(i).get(1).length()-1; j++) {
                String sub = forms.get(i).get(1).substring(j,j+2);
                for(int k = 0; k < forms.size(); k++){
                    if(k == i)
                        continue;
                    if(forms.get(k).get(1).contains(sub)){
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