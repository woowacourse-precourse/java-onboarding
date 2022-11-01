package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, ArrayList<String>> consecutiveLettersMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (!email.endsWith("@email.com")) {  // 이메일의 도메인 확인
                continue;
            }
        }

        return answer;
    }
}