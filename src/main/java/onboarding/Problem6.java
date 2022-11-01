package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        try {
            validateData(forms);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return answer;
    }

    private static void validateData(List<List<String>> forms) throws IllegalArgumentException {
        validateCrewSize(forms);
        validateEmail(forms);
        validateNickname(forms);
    }

    private static void validateCrewSize(List<List<String>> forms) throws IllegalArgumentException {
        if (!(1 <= forms.size()) && (forms.size() >= 10000)) {
            throw new IllegalArgumentException("올바른 크루원의 수가 아닙니다");
        }
    }
    private static void validateEmail(List<List<String>> forms) throws IllegalArgumentException {
        for (List<String> form : forms) {
            String email = form.get(0);
            if (!((11 <= email.length()) && (email.length() < 20))) {
                throw new IllegalArgumentException("올바른 이메일의 길이는 11 이상 20 미만입니다.");
            }

            final String EMAIL_REGEX  = "^\\w+@email\\.com";
            if (!Pattern.matches(EMAIL_REGEX, email)) {
                throw new IllegalArgumentException("유효한 이메일 형태가 아닙니다.");
            }
        }
    }

    private static void validateNickname(List<List<String>> forms) throws IllegalArgumentException {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            if (!((1 <= nickname.length()) && (nickname.length() < 20))) {
                throw new IllegalArgumentException("올바른 닉네임의 길이는 1 이상 20 미만입니다.");
            }

            final String NICKNAME_REGEX = "[가-힣]+$";
            if (!Pattern.matches(NICKNAME_REGEX, nickname)) {
                throw new IllegalArgumentException("유효한 이메일 형태가 아닙니다.");
            }
        }
    }
}
