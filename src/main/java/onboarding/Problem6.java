package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        // 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵 생성
        Map<String, String> emailToNameMap = makeEmailToNameMap(forms);

        List<String> answer = List.of("answer");
        return answer;
    }

    // 이메일을 KEY, 닉네임을 VALUE로 갖는 해시맵을 생성하는 메서드
    public static Map<String, String> makeEmailToNameMap(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        for (List<String> form : forms) {
            map.put(form.get(EMAIL), form.get(NICK_NAME));
        }
        return map;
    }

}
