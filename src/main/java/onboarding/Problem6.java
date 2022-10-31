package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for(int i=0; i<forms.size()-1;i++){
            for(int j=i+1; i<forms.size();j++){
                // forms[i][1]과 forms[j][1]을 비교해서 같다면
                // emails에 form[i][0]과 form[j][0]을 입력한다
            }
        }

        return emails;
    }
}
