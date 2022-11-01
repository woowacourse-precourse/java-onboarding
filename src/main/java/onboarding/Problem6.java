package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (List<String> form : forms) {
            System.out.println(isValidForm(form));
        }
        return answer;
    }

    public static boolean isValidForm(List<String> form) {
        if (!isValidEmailForm(form.get(0))) return false;
        if (!isValidNicknameForm(form.get(1))) return false;
        return true;
    }

    public static boolean isValidEmailForm(String email) {
        String regex = "^[a-z_0-9]{1,9}(@email.com)$";
        return email.matches(regex);
    }

    public static boolean isValidNicknameForm(String nickname) {
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        return nickname.matches(regex);
    }
}
