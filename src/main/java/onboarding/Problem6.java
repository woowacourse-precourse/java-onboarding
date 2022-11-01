package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> emailSet = new TreeSet<>();
        int crewNumber = forms.size();
        for(int i = 0; i < crewNumber; i++){
            for(int j = i; j < crewNumber; j++){
                if(i==j){
                    continue;
                }
                String firstNickame = forms.get(j).get(1);
                String secondNickname = forms.get(i).get(1);
                if(isOverlaps(firstNickame,secondNickname)) {
                    emailSet.add(forms.get(j).get(0));
                    emailSet.add(forms.get(i).get(0));
                }
            }
        }
        List<String> answer = new ArrayList<>(emailSet);

        return answer;
    }
    public static boolean isOverlaps(String firstString, String secondString){
        boolean ret = false;
        for(int i = 0; i < firstString.length()-1; i++){
            String comparedString = firstString.substring(i,i+2);
            if(secondString.contains(comparedString)){
                ret = true;
                break;
            }
        }

        return ret;
    }
}

