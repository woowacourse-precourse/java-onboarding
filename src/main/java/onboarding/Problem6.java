package onboarding;

import java.util.*;

public class Problem6 {
    public static Set<String> checkDupl(List<List<String>> forms){
        Set<String> result = new HashSet<>();
        
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(checkDupl(forms));
        Collections.sort(answer);
        return answer;
    }
}
