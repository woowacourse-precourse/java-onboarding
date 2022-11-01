package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i=0; i<forms.size()-1; i++){
            String name1 = forms.get(i).get(1);
            for(int j=i+1; j<forms.size(); j++){
                String name2 = forms.get(j).get(1);
                for(int k=0; k<name2.length()-1; k++){
                    String word = name2.substring(k, k+2);
                    if(name1.contains(word)){
                        if(!answer.contains(forms.get(i).get(0))) {
                            answer.add(forms.get(i).get(0));
                        }
                        if(!answer.contains(forms.get(j).get(0))) {
                            answer.add(forms.get(j).get(0));
                        }
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
