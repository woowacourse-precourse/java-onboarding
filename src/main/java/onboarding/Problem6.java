package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> temp = new HashSet<String>();
        for (int i=0; i<forms.size(); i++) {
            String word = forms.get(i).get(1);
            for (int k = 0; k < word.length() - 1; k++) {
                String twoChar = word.substring(k, k+2);
                for (int j = 0; j < forms.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    String curr = forms.get(j).get(1);
                    if (curr.contains(twoChar)) {
                        temp.add(forms.get(j).get(0));
                    }
                }
            }
        }
        List<String> answer =new ArrayList<String>(temp);
        Collections.sort(answer);
        return answer;
    }
}
