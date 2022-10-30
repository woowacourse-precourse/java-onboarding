package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> overlap= new HashSet<>();

        for(int i=0 ; i<forms.size(); i++){
            List<String> crewInfo = forms.get(i);
            String crewEmail=crewInfo.get(0);
            String crewName=crewInfo.get(1);
            for(int j=i+1; j<forms.size();j++){
                List<String> checkCrewInfo=forms.get(j);
                String checkCrewEmail=checkCrewInfo.get(0);
                String checkCrewName=checkCrewInfo.get(1);
                int leastLen=2;
                for(int idx=0; idx<crewName.length()-leastLen;idx++){
                    if(checkCrewName.contains(crewName.substring(idx,idx+leastLen))){
                        overlap.add(crewEmail);
                        overlap.add(checkCrewEmail);
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>(overlap);
        Collections.sort(ans);
        return ans;
    }
}
