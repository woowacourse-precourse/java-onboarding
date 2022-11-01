package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();

        Collections.sort(answer);
        return answer;
    }

    private static void checkOtherString(List<List<String>> forms, List<String> answer, int originalStringIndex, List<String> stringUnit, String email) {
        boolean overlap =false;
        overlap = reOverlap(forms, originalStringIndex, stringUnit, overlap);
        if(overlap){
            answer.add(email);
        }
    }
    private static boolean reOverlap(List<List<String>> forms, int originalStringIndex, List<String> stringUnit, boolean overlap) {
        for(int j = 0; j< forms.size(); j++){
            String otherNickName = forms.get(j).get(1);
            if(originalStringIndex ==j){
                continue;
            }
            overlap = checkOverlap(stringUnit, overlap, otherNickName);
            if(overlap){
                break;
            }
        }
        return overlap;
    }
    private static boolean checkOverlap(List<String> stringUnit, boolean overlap, String otherNickName) {
        for(int n = 0; n< stringUnit.size(); n++){
            if(otherNickName.contains(stringUnit.get(n))){
                overlap =true;
                break;
            }
        }
        return overlap;
    }

}
