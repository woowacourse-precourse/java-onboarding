package onboarding;

import java.util.List;

public class Problem6 {
    final static String EMAIL_DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if (checkMemberLimit(forms)) {
            return null;
        }
        return answer;
    }

    private static boolean checkMemberLimit(List<List<String>> forms) {
        // 크루원 1 이상 10000 이하 검증
        if (forms.size() >= 1 && forms.size() <= 10000) {
            return false;
        }
        return true;
    }

    private static boolean checkMemberException(String nickName, String email) {
        if (checkEmailException(email) || checkNickNameLengthException(nickName)) {
            return true;
        }
        return false;
    }

    private static boolean checkNickNameLengthException(String nickName) {
        if (nickName.length() >= 1 && nickName.length() < 20) {
            return false;
        }
        return true;
    }

    private static boolean checkEmailException(String email) {
        int section = email.indexOf("@") + 1;
        String domain = email.substring(section);
        if (!(email.length() >= 11 && email.length() < 20)) {
            return true;
        }
        if (!domain.equals(EMAIL_DOMAIN)) {
            return true;
        }
        return false;
    }
}
