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
            duplicateName(forms);

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

    public static void duplicateName(List<List<String>> forms){
        List<String> nameArray = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            nameArray.add(forms.get(i).get(1));
        }

        for (int i = 0; i < forms.size(); i++){
            System.out.println(nameArray.get(i).length());
            for (int j = 0; j < nameArray.get(i).length(); j++) {
                if (j + 1 < nameArray.get(i).length()) {
                    String duplication = nameArray.get(i).substring(j,j + 2);
                    System.out.println(nameArray.contains(duplication));
                }
            }
        }
    }
}
