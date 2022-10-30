package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> set= new HashSet<>();
        for(int i=0 ; i<forms.size(); i++){
            List<String> crewInfo = forms.get(i);
            for(int j=i+1; j<forms.size();j++){
                String crewName=crewInfo.get(1);
                String crewEmail=crewInfo.get(0);
                for(int idx=0; idx<crewName.length()-2;idx++){
                    if(forms.get(j).get(1).contains(crewName.substring(idx,idx+2))){
                        set.add(crewEmail);
                        set.add(forms.get(j).get(0));
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
