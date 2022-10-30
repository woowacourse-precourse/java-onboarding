package onboarding;

import java.util.List;

public class Problem6 {

    private final static String EMAIL_DOMAIN = "@email.com";


    private static boolean checkEmail(String email) {
        if (email == null)
            return true;
        else if (email.length() < 11 || email.length() > 19)
            return true;
        else if (!email.endsWith(EMAIL_DOMAIN))
            return true;
        return false;
    }

    private static boolean checkParam(List<List<String>> forms) {
        if (forms == null)
            return true;
        int size = forms.size();
        if (size == 0 || size > 10000)
            return true;
        for (int i=0; i<size; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (checkEmail(email) || checkNickname(nickname))
                return true;
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
