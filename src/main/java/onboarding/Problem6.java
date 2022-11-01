package onboarding;

import java.util.*;

public class Problem6 {
    /**
     * 기능 목록
     * 0. 같은 글자가 연속으로 포함되는지 확인하는 것은 2글자
     *    기준으로만 하면 그보다 많은 글자 수는 실행할 필요가 없다.
     * 1. forms의 각 닉네임을 2자씩 잘라서 hashSet에 보관(중복 제거)
     * 2. hashSet 원소를 map에 email과 함께 보관할껀데
     * 3. 처음보는 2글자 원소에 대해서만 저장하고
     * 4. 기존에 있던게 나오면 해당 email과 map에 있는 email을 treeSet에 저장한다.
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Map<String, String> map = new HashMap<>();
        Set<String> result = new TreeSet<>(); // 정렬과 중복 제거를 한 번에

        // 1. forms의 각 닉네임을 2자씩 잘라서 hashSet에 보관(중복 제거)
        for (List<String> form : forms) {
            String nick = form.get(1);
            HashSet<String> substrings = new HashSet<>();
            for (int i = 0; i < nick.length() - 1; i++) {
                substrings.add(nick.substring(i, i + 2));
            }

            /*
             2. hashSet 원소를 map에 email과 함께 보관할껀데
             3. 처음보는 2글자 원소에 대해서만 저장하고
             4. 기존에 있던게 나오면 해당 email과 map에 있는 email을 treeSet에 저장한다.
             */
            for(String substr : substrings) {
                if(!map.containsKey(substr)) {
                    map.put(substr, form.get(0));
                } else {
                    result.add(form.get(0));
                    result.add(map.get(substr));
                }
            }
        }
        answer = new ArrayList<>(result);
        return answer;
    }
}
