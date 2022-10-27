package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        findDuplicateNickname(forms);
        return answer;
    }

    private static void findDuplicateNickname(List<List<String>> forms) {
        for (List<String> crewForm : forms) {
            String email = crewForm.get(0);
            String nickname = crewForm.get(1);
            if (!validateEmail(email) || !validateNickname(nickname)) {
                continue;
            }
        }
    }

    private static boolean validateEmail(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            return false;
        }

        if (!email.contains("email.com")) {
            return false;
        }

        return true;
    }

    private static boolean validateNickname(String nickname) {
        if (!nickname.matches("^[ㄱ-ㅎ가-힣]*$")) {
            return false;
        }

        if (nickname.length() < 1 || nickname.length() >= 20) {
            return false;
        }

        return true;
    }
}
