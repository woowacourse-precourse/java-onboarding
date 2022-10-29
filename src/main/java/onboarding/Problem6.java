package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    private static final HashMap<String, String> map = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> form: forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (String part: sliceByLength(nickname, 2)) {
                if (isAlreadyUse(part, email)) {
                    answer.add(map.get(part));
                    answer.add(email);
                }
                map.put(part, email);
            }
        }

        return answer;
    }

    private static boolean isAlreadyUse(String part, String email) {
        return map.containsKey(part) && !map.get(part).equals(email);
    }

    private static List<String> sliceByLength(String str, Integer len) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= str.length() - len; i++) {
            result.add(str.substring(i, i + len));
        }

        return result;
    }
}

