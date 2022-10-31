package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> userEmail = new ArrayList<>();
        List<String> userNickname = new ArrayList<>();
        List<String> answer = List.of("answer");

        for (int i = 0; i < forms.size(); i++) {
            List<String> currentForm= forms.get(i);
            userEmail.add(getEmail(currentForm));
            userNickname.add(getNickname(currentForm));
        }

        for (int i = 0; i < userEmail.size(); i++) {
            String currentEmail = userEmail.get(i);
            if (!isValidEmail(currentEmail)){
                answer = List.of("wrong email");
                return answer;
            }
        }
//        if (isValidEmail(forms.get(0).get(0))){
//            List<String> answer = List.of("correct");
//            return answer;
//        }
//
//        List<String> answer = List.of("wrong");



        return answer;
    }

    private static Boolean isValidEmail(String email){
        char at = '@';

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == at){
                System.out.println(getDomain(email, i + 1));
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

    private static String getEmail(List<String> form){
        return form.get(0);
    }

    private static String getNickname(List<String> form){
        return form.get(1);
    }


}
