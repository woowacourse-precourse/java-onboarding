package onboarding;

import java.util.*;

/*
1. 형식 체크하기
2. 문자열 토큰 얻기
3. 중복 확인하기
4. 중복 추가하기
5. 정렬하기
 */

public class Problem6 {

    private static boolean isValidEmail(String email) {
        if (email.matches(".*@email.com") && 10 < email.length() && email.length() < 20)
            return true;
        return false;
    }

    private static boolean isValidName(String name) {
        if (name.matches("^[가-힣]*$") && 0 < name.length() && name.length() < 20)
            return true;
        return false;
    }

    private static Set<String> getNameToken(String name) {
        Set<String> nameToken = new HashSet<>();
        for (int i = 0; i < name.length() - 1; i ++) {
            nameToken.add(name.substring(i, i + 2));
        }
        return nameToken;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
