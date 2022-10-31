package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Boolean isValidEmail(String email){
        char at = '@';

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == at){
                return isDomainEmail(getDomain(email, i + 1));
            }
        }
        return false;
    }

    private static String getDomain(String email, int i){
        return email.substring(i);
    }

    private static Boolean isDomainEmail(String emailDomain){
        String domain = "email.com";
        return emailDomain.equals(domain);
    }
}
