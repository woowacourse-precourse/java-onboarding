package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        Set<List<String>> set = new HashSet<>();



        for (int i=0;i<forms.size();i++) {
            for (int n=i+1;n<forms.size();n++) {
                for (int j = 1; j < forms.get(i).get(1).length(); j++) {
                    for (int k = 1; k < forms.get(n).get(1).length(); k++) {
                        if (forms.get(i).get(1).charAt(j - 1) == forms.get(n).get(1).charAt(k - 1) && forms.get(i).get(1).charAt(j) == forms.get(n).get(1).charAt(k)) {
                            set.add(forms.get(n));
                            set.add(forms.get(i));
                        }
                    }
                }
            }
        }

        List<List<String>> ans = new ArrayList<>(set);
        for (int i=0;i<ans.size();i++) {
            answer.add(ans.get(i).get(0));
        }
        Collections.sort(answer);


        return answer;
    }
}
