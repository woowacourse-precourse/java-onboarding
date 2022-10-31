package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, List<String>> toHashMap(List<List<String>> forms) {
        Map<String, List<String>> nicknameParts = new HashMap<>();
        for (List<String> form : forms) {
            nicknameParts.put(form.get(0), separateNickname(form.get(1)));
        }
        return nicknameParts;
    }

    public static List<String> separateNickname(String nickname) {
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            parts.add(nickname.substring(i, i + 2));
        }
        return parts;
    }

    public static List<List<String>> separateNicknameList(Map<String, List<String>> mapForms) {
        List<List<String>> duplicateNickname = new ArrayList<>();
        for (Map.Entry<String, List<String>> elements : mapForms.entrySet()) {
            duplicateNickname.add(elements.getValue());
        }
        return duplicateNickname;
    }
}
