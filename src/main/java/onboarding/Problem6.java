package onboarding;

import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class Problem6 {

    private final static Pattern emailRegexPattern = compile("^(.+)@email.com");
    
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        assert validateEmail(forms);
        
        return answer;
    }

    private static boolean validateEmail(List<List<String>> forms) {
        return forms.stream()
                .map(form -> form.get(0))
                .allMatch(Problem6::isEmailValidate);
    }

    private static boolean isEmailValidate(String email) {
        return checkEmailFormat(email) && checkEmailLength(email);
    }

    private static boolean checkEmailFormat(String email) {
        return emailRegexPattern.matcher(email).matches();
    }

    private static boolean checkEmailLength(String email) {
        return email.length() >= 11 && email.length() < 20;
    }
}
