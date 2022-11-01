package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        answer = reAnswer(forms, answer);
        Collections.sort(answer);
        return answer;
    }
        private static List<String> reAnswer(List<List<String>> forms, List<String> answer) {
        for(int i = 0; i< forms.size(); i++){
            List<String> stringUnit = new ArrayList<>();
            int nickNameLength = forms.get(i).get(1).length();
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            stringUnit = getOriginalStringUnit(stringUnit, nickNameLength, nickName);
            checkOtherString(forms, answer, i, stringUnit, email);
        }
        return answer;
    }
    private static List<String> getOriginalStringUnit(List<String> stringUnit, int nickNameLength, String nickName) {
        for(int n = 0; n< nickNameLength -1; n++){
            for(int m = n; m< nickNameLength; m++){
                String nickNameSubString = nickName.substring(n,m+1);
                if(nickNameSubString.length()>=2){
                    stringUnit.add(nickNameSubString);
                }
            }
        }
        return stringUnit;
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
