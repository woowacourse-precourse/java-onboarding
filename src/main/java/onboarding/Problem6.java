package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Map<String, String> memberMap = memberListToMap(forms);
        List<String> answer = findDuplicatedNickname(fo);
        return answer;
    }

    private static Map<String, String> memberListToMap(List<List<String>> forms) {

        Map<String, String> member = new HashMap<>();
        for (List i : forms) {
            member.put((String) i.get(1), (String) i.get(0));
        }
        return member;
    }
}
