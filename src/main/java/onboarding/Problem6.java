package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            List<String> answer = List.of("answer");
            List<String> emailList = setInit(forms, 0);
            List<String> nameList = setInit(forms, 1);

            verificationEmail(emailList);

            return answer;
        } catch (Exception error) {
            return (List<String>) error;
        }
    }

    public static List<String> setInit(List<List<String>> forms, int index) {
        List<String> initlist = new ArrayList<>();
        for (List<String> form : forms) {
            initlist.add(form.get(index));
        }

        return  initlist;
    }

    public  static void verificationEmail(List<String> forms) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";

        for (String form : forms) {
            if (!(Pattern.matches(emailPattern, form))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
