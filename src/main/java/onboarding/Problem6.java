package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkDuplication(String fistNickname, String SecondNickname){
        for (int i =0 ; i<fistNickname.length()-2 ; i++){
            if (SecondNickname.contains(fistNickname.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }

    public static boolean[] getDuplicatedCrewIndexes(List<List<String>> forms){
        int totalCrewNum = forms.size();
        boolean[] duplicatedCrewIndexes = new boolean[totalCrewNum];
        for (int i = 0; i<totalCrewNum-1 ; i++){

            if (duplicatedCrewIndexes[i]){
                continue;
            }

            for (int j = i+1; j<totalCrewNum;j++){
                if(checkDuplication(forms.get(i).get(1),forms.get(j).get(1))){
                    duplicatedCrewIndexes[i] = true;
                    duplicatedCrewIndexes[j] = true;
                }
            }
        }
        return duplicatedCrewIndexes;
    }

}
