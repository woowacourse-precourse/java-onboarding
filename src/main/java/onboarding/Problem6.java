package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new TreeSet<>();

        for(int idx1 = 0; idx1 < forms.size(); idx1++) {
            Set<String> cands = new HashSet<>();

            String first = forms.get(idx1).get(1);
            for(int idx = 0; idx < first.length() - 1; idx++) {
                cands.add(first.substring(idx, idx + 2));
            }

            for(int idx2 = idx1 + 1; idx2 < forms.size(); idx2++) {
                String second = forms.get(idx2).get(1);
                for(int idx = 0; idx < second.length() - 1; idx++) {
                    if(cands.contains(second.substring(idx, idx + 2))) {
                        answer.add(forms.get(idx1).get(0));
                        answer.add(forms.get(idx2).get(0));
                    }
                }
            }
        }

        return answer.stream().collect(Collectors.toList());
    }
}
