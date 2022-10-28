package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    private static Map<String, Set<String>> limitedNicknameMap = new HashMap<>();
    private static Set<String> answer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (nickname.length() < 2)
                continue;
        }

        List<String> retAnswer = new ArrayList<>(answer);
        return retAnswer;
    }
}
