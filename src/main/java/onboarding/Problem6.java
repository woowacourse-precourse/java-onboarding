package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (isException(forms)) throw new RuntimeException("잘못된 인자입니다.");
        List<String> answer = List.of("answer");
        return answer;
    }

    private static Boolean isException(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 1000000) return true;
        return forms.stream()
                .anyMatch(form ->
                        (form.get(1).length() < 1 || form.get(1).length() > 20) ||
                                (form.get(0).length() < 11 || form.get(0).length() > 20));
    }

    private static void setEmailMap(String stringToken, Map<String, List<String>> emailMap, String email) {
        if (emailMap.get(stringToken) == null) {
            emailMap.put(stringToken, new ArrayList<>() {{
                add(email);
            }});
            return;
        }
        emailMap.get(stringToken).add(email);
    }

    private static void nicknameSplitByTwo(String nickname, Map<String, List<String>> emailMap, String email) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            setEmailMap(nickname.substring(i, i + 2), emailMap, email);
        }
    }


}
