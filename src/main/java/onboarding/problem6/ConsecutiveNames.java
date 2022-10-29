package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 이름에 대한 연속적인 이름 집합을 저장하는 클래스입니다.
public class ConsecutiveNames {
    private Set<String> names = new HashSet<>();

    public ConsecutiveNames(final String name) {
        this.names = ConsecutiveNameGenerator.generate(name);
    }

    public boolean isSimilar(ConsecutiveNames consecutiveNames) {
        // 모든 요소를 순회하면서 하나라도 포함하면 true를 반환합니다.
        for (String name : names) {
            if (consecutiveNames.names.contains(name)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> names() {
        return new ArrayList<>(names);
    }
}
