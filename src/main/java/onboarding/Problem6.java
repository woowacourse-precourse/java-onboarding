package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> map = new HashMap<>();
        /*두 글자 이상 문자 분리, 중복 있을 시 중복된 닉네임의 이메일 저장*/
        for (List<String> form : forms) {
            divideTwoWord(map, form);
        }

        /*이메일 중복 제거*/

        return answer;
    }

    private static void divideTwoWord(Map<String, Set<String>> map, List<String> form) {
        String nickname = form.get(1);
        for (int i = 1; i < nickname.length(); ++i) {
            String twoWord = nickname.substring(i-1, i);
            if (map.containsKey(twoWord)) {
                map.get(twoWord).add(form.get(0));
                continue;
            }
            map.put(twoWord, new HashSet<>());
            map.get(twoWord).add(form.get(0));
        }
    }
}
