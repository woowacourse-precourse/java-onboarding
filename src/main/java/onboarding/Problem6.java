package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean checkEmail(String email) throws Exception {
        if (email.length() < 11 || email.length() >= 20) {
            throw new Exception("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.");
        }
        if (!"@email.com".equals(email.substring(email.length() - 10))) {
            throw new Exception("이메일은 '@email.com' 도메인만 가능합니다.");
        }
        String emailId = email.substring(1, email.length() - 10);
        if (!emailId.matches("^[a-z0-9A-Z]*$")) {
            throw new Exception("이메일은 알파벳과 숫자로만 만들 수 있습니다.");
        }
        return true;
    }
}
