package onboarding;

import java.util.*;

public class Problem6 {
    public static Set<String> checkDupl(List<List<String>> forms){
        Set<String> result = new HashSet<>();
        for(int i=0;i<forms.size()-1;i++){
            String nickname = forms.get(i).get(1);
            String[] nameArr = nickname.split("");
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(checkDupl(forms));
        Collections.sort(answer);
        return answer;
    }
}
