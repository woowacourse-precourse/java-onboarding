package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> nameMap = new HashMap<>();

        /* map.getOrDefault() 학습 후 리팩토링 */
        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String subName = name.substring(i, i + 2);
                nameMap.put(subName, nameMap.getOrDefault(subName, 0) + 1);
            }
        }

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length() - 1; i++) {
                String subName = name.substring(i, i + 2);
                if (nameMap.get(subName) - 1 > 1) {
                    answer.add(form.get(0));
                    break;
                }
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
