package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> answer1 = new ArrayList<>();

        for (int i = 0; i < forms.size()-1; i++) {
            int name_length = forms.get(i).get(1).length();

            for (int a = 0; a < name_length-1; a++){
                String word = forms.get(i).get(1).substring(a,a+2);

                for (int b = i+1; b < forms.size(); b++) {

                    if (forms.get(b).get(1).contains(word)) {
                        answer1.add(forms.get(b).get(0));
                        answer1.add(forms.get(i).get(0));
                    }//if
                }//for3
            }//for2
        }//for1
        Set<String> answer_set = new HashSet<>(answer1);
        answer = new ArrayList<>(answer_set);
        Collections.sort(answer);
        return answer;
    }
}
