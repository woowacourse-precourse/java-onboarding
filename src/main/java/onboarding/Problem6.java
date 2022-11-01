package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        if (!isValidCrewSize(forms.size())) {
            return Collections.emptyList();
        }

        return answer;
    }

    private static boolean isValidCrewSize(int size) {
        return size >= 1 && size <= 10000;
    }

    private static boolean checkLength(String emails) {
        int emailLength = emails.length();
        return emailLength >= 11 && emailLength < 20;
    }

    private static boolean checkDomain(String emails) {
        String str = "@email.com";
        return emails.substring(emails.indexOf('@')).equals(str);
    }

    private static boolean checkNickValid(String nickname) {
        return nickname.matches("^[가-힣]*$") == true;
    }

    private static boolean checkNickLength(String nickname) {
        return nickname.length() >= 1 && nickname.length() < 20;
    }

}
