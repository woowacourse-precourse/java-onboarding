package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String str = forms.get(i).get(1).charAt(j) + "" + forms.get(i).get(1).charAt(j + 1);
                for(int k = i + 1; k < forms.size(); k++) {
                    if(forms.get(k).get(1).contains(str)) {
                        if(!(answer.contains(forms.get(k).get(0)))) {
                            if(answer.contains(forms.get(i).get(0))) {
                                answer.add(forms.get(k).get(0));
                                continue;
                            }
                            answer.add(forms.get(k).get(0));
                            answer.add(forms.get(i).get(0));
                        }
                    }
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
