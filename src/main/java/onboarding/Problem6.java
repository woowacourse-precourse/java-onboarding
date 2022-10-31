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

        for (int i = 0; i < userNickname.size(); i++) {
            Boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (isDuplicationName(userNickname.get(i), userNickname.get(j))){
                    flag = true;
                }
            }
            for (int j = i + 1; j < userNickname.size(); j++) {
                if (isDuplicationName(userNickname.get(i), userNickname.get(j))){
                    flag = true;
                }
            }
            System.out.println(flag);
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

    private static boolean isDuplicationName(String name1, String name2){
        char currentName1Char, previousName1Char;
        if (name1.length() < 2 || name2.length() < 2){
            return false;
        }

        for (int i = 1; i < name1.length(); i++) {
            currentName1Char = name1.charAt(i);
            previousName1Char = name1.charAt(i - 1);
            if (checkDuplicationWord(currentName1Char, previousName1Char, name2)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkChar(char a, char b){
        return (a == b);
    }

    private static boolean checkDuplicationWord(char currentName1Char, char previousName1Char, String name2){
        char currentName2Char, previousName2Char;
        for (int j = 1; j < name2.length(); j++) {
            currentName2Char = name2.charAt(j);
            previousName2Char = name2.charAt(j - 1);
            if (checkChar(currentName1Char, currentName2Char) && (checkChar(previousName1Char, previousName2Char))){
                return true;
            }
        }
        return false;
    }


}
