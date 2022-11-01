package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        boolean checkDomain = checkDomain(forms);
        if(!checkDomain) {
            List<String> falseDomain = new ArrayList<>();
            falseDomain.add("false");
            return falseDomain;
        }


        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkDomain(List<List<String>> forms) {
        for(int i = 0, j=0; i<forms.size(); i++) {
            String checkForms = forms.get(i).get(j);

            if(!checkForms.contains("email.com")) {
                return false;
            }
        }
        return true;
    }
}
