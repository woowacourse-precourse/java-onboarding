package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            List<String> answer = List.of("answer");

            verificationEmail(forms);

            return answer;
        } catch (Exception error){
            return (List<String>) error;
        }
    }

    public  static void verificationEmail(List<List<String>> forms) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";

        for (int i = 0; i < forms.size(); i++) {
            if (!(Pattern.matches(emailPattern, forms.get(i).get(0)))) {
                throw new IllegalArgumentException();
            }
        }
    }


}
