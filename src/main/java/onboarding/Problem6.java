package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> set=new HashSet<>();
        String str="";
        for (int i = 0; i < forms.size()-1; i++) {
            for (int j = i+1; j < forms.size(); j++) {
                for (int k = 0; k < forms.get(j).get(1).length()-1; k++) {
                    if(forms.get(i).get(1).indexOf(forms.get(j).get(1).substring(k, k+1))>=0){
                        set.add(forms.get(i).get(0));
                    }
                }
            }
        }
        answer=new ArrayList<>(set);


        return answer;
    }
}
