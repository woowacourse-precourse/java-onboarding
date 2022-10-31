package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0; i<forms.size(); i++){
            String name = new String();
            name = forms.get(i).get(1);
            for(int j=0; j<name.length()-1; j++){
                String tmp = name.substring(j,j+2);
                for(int k=i+1; k<forms.size(); k++){
                    String tmp2 = forms.get(k).get(1);
                    if(tmp2.contains(tmp)) answer.add(forms.get(k).get(0));
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        List<String> ans = new ArrayList<String>(set);
        Collections.sort(ans);
        return ans;
    }
}

