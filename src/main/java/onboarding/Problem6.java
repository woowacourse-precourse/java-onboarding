package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    /**
     * 기능 목록 작성
     * 1. 중복 체크를 할 수 있는 패턴들을 찾는 기능
     * 2. 패턴에 중복되는 닉네임이 2개 이상일때 set에 추가하는 기능
     */
    public static List<String> solution(List<List<String>> forms) {
        Set<String> namePatterns = new HashSet<>();
        List<String> names = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                namePatterns.add(name.substring(i, i + 2));
            }
            map.put(name, email);
            names.add(name);
        }

        Set<String> answer = new HashSet<>();
        Set<String> tempAnswer = new HashSet<>();
        for (String pattern : namePatterns) {
            int dupCount = 0;
            for (String name : names) {
                if (name.contains(pattern)) {
                    dupCount++;
                    tempAnswer.add(map.get(name));
                }
            }
            if (dupCount  > 1) {
                answer.addAll(tempAnswer);
            }
            tempAnswer.clear();
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }
}
