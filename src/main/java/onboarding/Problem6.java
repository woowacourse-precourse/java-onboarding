package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> IsFalse= new ArrayList<>();
        IsFalse.add("false");

        boolean checkDomain = checkDomain(forms);
        if(!checkDomain) {
            return IsFalse;
        }

        boolean checkNickName = checkNickName(forms);
        if(!checkNickName) {
            return IsFalse;
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

    public static boolean checkNickName(List<List<String>> forms) {
        String pattern = "^[a-zA-Z]*$";
        for(int i = 0,j=1; i<forms.size(); i++) {
            String checkForms = forms.get(i).get(j);

            if(!checkForms.matches(pattern)) {
                return false;
            }
        }
        return true;
    }
}
