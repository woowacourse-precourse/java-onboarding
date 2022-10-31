package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList();

        int len = forms.size();
        for (int i = 0; i < len ; i++){
            int name_length = forms.get(i).get(1).length();
            
            for (int j = 0; j < name_length - 1; j++){
                String s = forms.get(i).get(1).substring(j, j+2);
                for (int k = 0; k < len; k++){
                    if (k != i)  {
                        if (forms.get(k).get(1).contains(s)) {
                            if (!answer.contains(forms.get(i).get(0)))
                                answer.add(forms.get(i).get(0));
                        }
                    }
                    else continue;
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
