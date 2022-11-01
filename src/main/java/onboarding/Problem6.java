package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;


public class Problem6 {
    private static Map<String, String> map = new HashMap<>();
    private static Set<String> set = new TreeSet<>();

    public static List<String> solution(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);
            nickNameCombination(email, nickName);
        }
        List<String> answer = new ArrayList<>(set);
        return answer;
    }

    private static void nickNameCombination(String email, String nickName) {
        if (nickName.length() < 2) {
            return;
        }
        for (int i = 0; i < nickName.length() - 1; i++) {
            String combination = nickName.substring(i, i + 2);
            final String prevEmail = map.get(combination);
            if (map.containsKey(combination)) {
                set.add(prevEmail);
                set.add(email);
            }
            map.put(combination, email);
        }
    }
}
