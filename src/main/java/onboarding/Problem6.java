package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emails = new HashSet<>();

        for (List<String> form : forms) {
            String name = form.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                String str = name.substring(i, i + 2);

                for (List<String> list : forms) {
                    if (form != list && list.get(1).contains(str)) {
                        emails.add(form.get(0));
                        emails.add(list.get(0));
                    }
                }
            }
        }

        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);

        return answer;
    }
}
