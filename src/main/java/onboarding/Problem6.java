package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int count;
        String curr;
        String temp;
        for (int i = 0; i < forms.size(); i++) {
            curr = forms.get(i).get(1);
            count = 0;
            for (int j = 0; j < curr.length()-1; j++) {
                temp = curr.substring(j, j+2);
                for (int k = 0; k < forms.size(); k++) {
                   if(k != i && forms.get(k).get(1).matches(".*" + temp+".*")){
                       count++;
                   }
                }
            }
            if (count > 0) answer.add(forms.get(i).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
}
