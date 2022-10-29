package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    private static Set<String> answer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {

        return null;
    }

    public static void checkDuplicate(List<List<String>> forms, String checkName) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            if (name.contains(checkName)) {
                answer.add(email);
            }
        }
    }
}
