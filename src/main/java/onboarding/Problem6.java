package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> delDuplicate(List<String> emails){
        ArrayList<String> newList = new ArrayList<String>();

        if(emails.size() >= 2) {
            for (String email : emails) {
                if (!newList.contains(email)){
                    newList.add(email);
                }
            }
        }

        return newList;
    }

    public static List<List<String>> isAvailable(List<List<String>> forms){
        List<List<String>> available = new ArrayList<List<String>>();

        for (int i = 0; i < forms.size(); i ++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            String emailregex = "^[a-zA-Z0-9]{1,9}@email[.]com$";
            String nameregex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";

            if (email.length() > 10 && email.length() < 20 && Pattern.matches(emailregex, email) && Pattern.matches(nameregex, nickname)) {
                available.add(forms.get(i));
            }
        }
        return available;
    }
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
