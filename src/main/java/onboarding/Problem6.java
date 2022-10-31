package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        boolean[] setEmail = new boolean[forms.size()];

        for(int i = 0; i < forms.size(); i++) {
            for(int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String str = "" + forms.get(i).get(1).charAt(j) + forms.get(i).get(1).charAt(j + 1);
                for(int k = 0; k < forms.size(); k++)
                    if(forms.get(k).get(1).contains(str) && k != i)
                        setEmail[i] = true;
            }
        }

        for(int i = 0; i < setEmail.length; i++)
            if(setEmail[i])
                answer.add(forms.get(i).get(0));

        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
