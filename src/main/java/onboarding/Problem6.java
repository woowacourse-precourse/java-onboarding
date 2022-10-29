package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static final HashMap<String, String> dupCheckMap = new HashMap<>();
    private static final HashSet<String> emailSet = new HashSet<>();
    public static List<String> solution(List<List<String>> forms) {
        for (List<String> form: forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (String part: sliceByLength(nickname, 2)) {
                if (isAlreadyUse(part, email)) {
                    emailSet.add(dupCheckMap.get(part));
                    emailSet.add(email);
                }
                dupCheckMap.put(part, email);
            }
        }

        return new ArrayList<>(emailSet);
    }

    private static boolean isAlreadyUse(String part, String email) {
        return dupCheckMap.containsKey(part) && !dupCheckMap.get(part).equals(email);
    }

    private static List<String> sliceByLength(String str, Integer len) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= str.length() - len; i++) {
            result.add(str.substring(i, i + len));
        }

        return result;
    }
}

