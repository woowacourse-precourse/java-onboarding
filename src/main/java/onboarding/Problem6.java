package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> duplicateName(List<List<String>> forms){
        List<String> dupCheck = new ArrayList<>();
        List<String> dupList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j <= name.length()-2; j++) {
                String splitName = name.substring(j,j+2);
                if(dupCheck.contains(splitName) && !dupList.contains(splitName)){
                    dupList.add(splitName);
                } else if(!dupCheck.contains(splitName)) {
                    dupCheck.add(splitName);
                }
            }
        }
        return dupList;
    }
    public static List<String> duplicateCrewMail(List<List<String>> forms){
        List<String> dupMail = new ArrayList<>();
        List<String> dupList = duplicateName(forms);
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            for (int j = 0; j <= name.length()-2; j++) {
                String splitName = name.substring(j,j+2);
                for (int k = 0; k < dupList.size(); k++) {
                    if(dupList.contains(splitName) && !dupMail.contains(email)){
                        dupMail.add(email);
                    }
                }
            }
        }
        Collections.sort(dupMail);
        return dupMail;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = duplicateCrewMail(forms);
        return answer;
    }
}
