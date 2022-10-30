package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> overlap= new HashSet<>();

        for(int i=0 ; i<forms.size(); i++){
            String selectCrewName=crewName(forms,i);
            String selectCrewEmail=crewEmail(forms,i);
            for(int j=i+1; j<forms.size();j++){
                int leastLen=2;
                for(int idx=0; idx<selectCrewName.length()-leastLen;idx++){
                    String subCrewName=selectCrewName.substring(idx,idx+leastLen);
                    if(crewName(forms,j).contains(subCrewName)){
                        overlap.add(selectCrewEmail);
                        overlap.add(crewEmail(forms,j));
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>(overlap);
        Collections.sort(ans);
        return ans;
    }
    public static String crewName(List<List<String>>forms,int idx){
        List<String> crewInfo=forms.get(idx);
        return crewInfo.get(1);
    }
    public static String crewEmail(List<List<String>>forms,int idx){
        List<String> crewInfo=forms.get(idx);
        return crewInfo.get(0);
    }
}
