package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* 1. 닉네임의 2글자로 구성된 부분이름을 key,중복없이 이메일을 저장하는 Set 을 value 로 갖는 Map 생성
* 2. 닉네임이 1글자 이상인경우 이름을 나누어 Map 에 추가하는 함수 추가
*   2-1. 해당 부분이름에 해당하는 키가 Map 에 존재하지 않으면 Set 을 새로생성해 Map 에 추가
*   2-2. 부분이름으로 Map.get(key)에 이메일을 추가
* 3. Map 의 keySet 으로 각 key 의 value(이메일 Set)들 중 크기가 2 이상인 것들을 결과 Set(중복없이 저장)해 정렬 후 List 로 변환하여 반환하는 로직 추가
*/

public class Problem6 {
    private static Map<String, Set<String>> map;
    public static List<String> solution(List<List<String>> forms) {
        map = new HashMap<>();

        return List.of();
    }
}
