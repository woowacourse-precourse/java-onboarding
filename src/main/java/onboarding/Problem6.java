package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    /*
    static List<String> subName(List<List<String>> forms){
        for(int i=0; i<forms.get(i).get(1).length(); i++){
            String substring = forms.get(i).get(1).substring(i, i+3);
        }
    } */
    static List<String> findDup(List<List<String>> forms){
        List<String> mailList = new ArrayList<>();
        for(int i=0; i<forms.get(i).get(1).length()-2; i++){
            String substring = forms.get(i).get(1).substring(i, i+2);
            for(int j=0; j<forms.size(); j++){
                if(forms.get(j).get(1).contains(substring)){
                    mailList.add(forms.get(j).get(0));
                }
            }
        }
        return mailList;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = findDup(forms);   //List.of("answer");
        Collections.sort(answer);
        return answer;
    }
}
