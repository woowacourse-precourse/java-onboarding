package onboarding;

import java.util.*;

public class Problem6 {
// 슬라이딩 윈도우
    public static List<String> solution(List<List<String>> forms) {
        Map<String, Integer> duplicatedNames = new HashMap<>();

        for (List<String> form : forms) {
            String name = form.get(1);
            for (int i = 0; i < name.length()-1; i++) {
                String substring = name.substring(i, i + 2);
                duplicatedNames.merge(substring, 1, (oldValue, newValue) -> oldValue + 1);
            }
        }

        return null;
    }
}
