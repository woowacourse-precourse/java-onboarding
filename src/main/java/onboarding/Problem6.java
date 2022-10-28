package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static void validateEmails(List<List<String>> forms) throws Exception {
        String reg = "[A-Za-z0-9]+@email.com$";

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if(email.length() < 11 || 20 <= email.length()) throw new Exception("이메일의 전체 길이는 11자 이상 20자 미만이여야 합니다.");
            if(!email.matches(reg)) throw new Exception("이메일 형식에 맞지 않습니다.");
        }
    }

}
