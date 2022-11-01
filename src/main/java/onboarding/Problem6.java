package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        boolean check[] = new boolean[forms.size()];

        for(int i = 0; i < forms.size(); i++)
            check[i] = false;

        for(int i = 0; i < forms.size(); i++) {
            List<String> standard = forms.get(i);
            String standardName = standard.get(1);
            for(int j = 1; j < standardName.length(); j++){
                String piece = standardName.substring(j-1, j+1);
                for(int k = 0; k < forms.size(); k++){
                    List<String> compare = forms.get(k);
                    if(compare.get(0) == standard.get(0))
                        continue;
                    if(compare.get(1).contains(piece)) {
                        if(!check[k]) check[k]= true;
                    }
                }
            }
        }

        for(int i=0; i<forms.size(); i++){
            if(check[i]) {
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
