package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/*
* 1. 닉네임의 2글자로 구성된 부분이름을 key,중복없이 이메일을 저장하는 Set 을 value 로 갖는 Map 생성
* 2. getSubNames(): 닉네임을 파라미터로 받아 subname List를 만드는 메서드 추가
* 3. addSubNames(): 닉네임이 1글자 이상인경우 이름을 나누어 Map 에 추가하는 함수 추가
*   3-1. 해당 부분이름에 해당하는 키가 Map 에 존재하지 않으면 Set 을 새로생성해 Map 에 추가
*   3-2. 부분이름으로 Map.get(key)에 이메일을 추가
* 4. Map 의 keySet 으로 각 key 의 value(이메일 Set)들 중 크기가 2 이상인 것들을 결과 Set(중복없이 저장)해 정렬 후 List 로 변환하여 반환하는 로직 추가
*/

public class Problem6 {
    private static Map<String, Set<String>> map;
    public static List<String> solution(List<List<String>> forms) {
        map = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String name = form.get(1);

            if (name.length() >= 2) {
                addSubNames(name, email);
            }
        }

        return map.keySet().stream()
                .filter(subName -> map.get(subName).size() >= 2)
                .map(subName -> map.get(subName))
                .flatMap(Set::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> getSubNames(String name) {
        List<String> subNames = new ArrayList<>();

        for (int i = 0; i < name.length() - 1; i++) {
            subNames.add(name.substring(i, i + 2));
        }

        return subNames;
    }

    private static void addSubNames(String name, String email) {
        List<String> subNames = getSubNames(name);

        for (String subName : subNames) {
            if (!map.containsKey(subName)) {
                map.put(subName, new HashSet<>());
            }
            map.get(subName).add(email);
        }
    }
}
