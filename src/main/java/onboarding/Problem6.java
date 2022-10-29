package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(List.of("jm@email.com", "제이엠"), List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"), List.of("mj@email.com", "엠제이"), List.of("nowm@email.com", "이제엠"));
        System.out.println(solution(forms));
    }

    public static List<String> solution(List<List<String>> forms) {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> form : forms) {
            String nickName = form.get(1);

            for (int i = 0; i < nickName.length(); i++) {
                for (int j = i; j < nickName.length(); j++) {
                    if (j - i >= 1) {
                        String subName = nickName.substring(i, j + 1);

                        if (map.containsKey(subName)) {
                            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                                if (entry.getKey().equals(subName)) {
                                    if (!entry.getValue().get(0).equals(form.get(0))) {
                                        set.add(entry.getValue().get(0));
                                        set.add(form.get(0));
                                    }
                                }
                            }
                        }
                        map.put(subName, form);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}
