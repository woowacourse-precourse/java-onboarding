package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> check(List<List<String>> forms){
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < forms.size(); i++){
            String nickname = forms.get(i).get(1);
            for(int j = 0; j < nickname.length() - 1; j++){
                String part = nickname.substring(j, j+2);
                for(int n = i+1; n < forms.size(); n++){
                    String other = forms.get(n).get(1);
                    if(other.contains(part)){
                        set.add(forms.get(n).get(0));
                        set.add(forms.get(i).get(0));
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        return check(forms);
    }
}
