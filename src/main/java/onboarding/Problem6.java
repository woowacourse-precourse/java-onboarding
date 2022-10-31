package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> splited_name_email = new HashMap<>();
        Set<String> duplicate_email = new HashSet<>();

        for (List<String> list : forms) {
            for (int i = 0; i < list.get(1).length() - 1; i++) {
                String splited_name = "" + list.get(1).charAt(i) + list.get(1).charAt(i+1);

                if (splited_name_email.containsKey(splited_name)) {
                    duplicate_email.add(list.get(0));
                    duplicate_email.add(splited_name_email.get(splited_name));
                    continue;
                }

                splited_name_email.put(splited_name, list.get(0));
            }
        }

        List<String> answer = new ArrayList<>(duplicate_email);

        return answer;
    }
}