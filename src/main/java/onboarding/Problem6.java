package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void validationCheck(String email, String name) {
        if (!validateEmailCheck(email)) {
            throw new IllegalStateException("이메일 형식에 부합하지 않음");
        }

        if (!validateNicknameCheck(name)) {
            throw new IllegalStateException("닉네임 형식에 부합하지 않음");
        }
    }


    private static boolean validateEmailCheck(String email) {
        if (email.endsWith("email.com") &&
                11 <= email.length() && email.length() < 20) {
            return true;
        }

        return false;
    }


    private static boolean validateNicknameCheck(String nickname) {
        if (nickname.matches("^[가-힣]*$") &&
                0 < nickname.length() && nickname.length() < 20) {
            return true;
        }

        return false;
    }
}
