package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    /**
     * 이메일 도메인이 @email.com 인지 확인하는 함수
     */
    private static boolean isEmailDomain(String email){
        if (!email.endsWith("@email.com"))
            return false;
        else return true;
    }
}
