package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();
        HashSet<String> emails = new HashSet<>();
        for (List<String> form : forms) {
            String nameSet = form.get(1);
            for (int j = 0; j < nameSet.length() - 1; j++) {
                String same = nameSet.substring(j, j + 2);
                if (hashMap.containsKey(same)) {
                    String email = hashMap.get(same);
                    emails.add(email);
                    emails.add(form.get(0));
                }
                hashMap.put(same, form.get(0));
            }
        }
        List<String> list = new ArrayList<>(emails);
        list.sort(null);
        answer = list;
        return answer;
    }
}
