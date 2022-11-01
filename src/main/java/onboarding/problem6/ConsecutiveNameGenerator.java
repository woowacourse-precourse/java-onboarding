package onboarding.problem6;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNameGenerator {
    // 연속적인 숫자의 기준점
    private static Integer CONTINUOUS_CRITERION_NUMBER = 2;

    /**
     * 연속적인 문ㅂ자열을 가진 집합을 만듧니다.
     *
     * @param name
     * @return
     */
    private static Set<String> generateConsecutiveName(String name) {
        Set<String> temp = new HashSet<>();
        for (int i = 0; i < name.length(); i++) {
            for (int j = name.length(); j >= i + CONTINUOUS_CRITERION_NUMBER; j--) {
                temp.add(name.substring(i, j));
            }
        }
        return temp;
    }

    public static Set<String> generate(String name) {
        return generateConsecutiveName(name);
    }
}
