package onboarding;

import model.Crew;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if (!validCheck(forms))
            return List.of("error");

        Crew crew = new Crew(forms);
        return crew.alarm();
    }
    static boolean validCheck(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            if (!emailValidCheck(email) || !nicknameValidCheck(nickname)) {
                return false;
            }
        }
        return true;
    }

    static boolean emailValidCheck(String email) {
        int idx = email.indexOf("@");
        return email.length() >= 11 && email.length() < 20 && email.substring(idx + 1).equals("email.com");
    }

    static boolean nicknameValidCheck(String nickname) {
        Pattern pattern = Pattern.compile("^[ㄱ-ㅎ|가-힣]+$");
        Matcher matcher = pattern.matcher(nickname);
        return matcher.find() && nickname.length() >= 1 && nickname.length() < 20;
    }
}
