package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean nickname_test(String x, String y) {
        for(int i=0; i<x.length()-1; i++) {
            if (y.contains(x.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = new ArrayList<String>();
        for (int i=0; i<forms.size(); i++){
            for (int j=0; j<i; j++){
                if (nickname_test(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        Set<String> result = new HashSet<>(answer);
        List<String> final_answer = new ArrayList<String>(result);
        Collections.sort(final_answer);

        return final_answer;
    }
}
