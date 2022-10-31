package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashMap<String, Integer> overlap = new HashMap<String, Integer>();
        List<String> answer = new LinkedList<String>();
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).length() == 1)
                continue;
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                overlap.put(forms.get(i).get(1).substring(j, j + 2),
                        overlap.getOrDefault(forms.get(i).get(1).substring(j, j + 2), 0) + 1);

            }
        }
        for (int i = 0; i < forms.size(); i++) {
            if (forms.get(i).get(1).length() == 1)
                continue;
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                if (overlap.get(forms.get(i).get(1).substring(j, j + 2))>=2 ) {
                    answer.add(forms.get(i).get(0).substring(0, forms.get(i).get(0).length()-10));
                    break;
                }
            }
        }
        answer = answer.stream().distinct().collect(Collectors.toList());

        Collections.sort(answer);
        for(int i=0;i<answer.size();i++) {
            answer.set(i, answer.get(i)+"@email.com");
        }
        return answer;
    }
}
