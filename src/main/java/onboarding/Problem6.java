package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NAME = 1;

    private static final int MINIMUM_NAME_LENGTH = 2;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> map = new HashMap<>();
        List<String> answer = List.of("answer");

        for (List<String> form : forms) {
            nameCaseInsertMap(form.get(NAME), form.get(EMAIL), map);
        }

        return answer;
    }

    private static void nameCaseInsertMap(String name, String email, Map<String, String> map) {
        if (name.length() < MINIMUM_NAME_LENGTH) {
            return;
        }

        map.put(name, email);

        for (int i = 1; i < name.length(); i++) {
            nameCaseInsertMap(name.substring(i), email, map);
            nameCaseInsertMap(name.substring(0, name.length() - i), email, map);
        }
    }


}
