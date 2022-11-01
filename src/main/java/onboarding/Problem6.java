package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedCrewEmails(forms);
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

    public static List<String> getDuplicatedCrewEmails(List<List<String>> forms){
        boolean[] duplicatedCrewIndexes = getDuplicatedCrewIndexes(forms);
        List<String> duplicatedCrewEmail = new ArrayList<>();
        for(int i = 0; i< duplicatedCrewIndexes.length; i++){
            if(duplicatedCrewIndexes[i]){
                duplicatedCrewEmail.add(forms.get(i).get(0));
            }
        }
        Collections.sort(duplicatedCrewEmail);
        return duplicatedCrewEmail;
    }

}
