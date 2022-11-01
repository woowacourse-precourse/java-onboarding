package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new LinkedList<>();
        for (int i = 0; i < forms.size()-1; i++) {
            for (int j = i+1 ; j < forms.size(); j++) {
                answer.addAll(compare(forms.get(i),forms.get(j)));
            }
        }
        Set<String> test = new HashSet<>(answer);
        answer = test.stream().sorted().collect(Collectors.toList());
        return answer;
    }

    private static List<String> compare(List<String> now, List<String> next) {
        List<String> res = new LinkedList<>();
        for (int k = 0; k < now.get(1).length()-1; k++) {
            if(!next.get(1).contains(now.get(1).substring(k,k+2))){
                continue;
            }
            res.add(now.get(0));
            res.add(next.get(0));
            break;
        }
        return res;
    }
}
