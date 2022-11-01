package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> relationships = new HashMap<>();
        Map<String, Integer> recommendScore = new HashMap<>();

        // 친구 관계를 저장합니다.
        for(List<String> e : friends) {
            String key = e.get(0);
            String value = e.get(1);

            if(!relationships.containsKey(key)) relationships.put(key, new ArrayList<>());
            relationships.get(key).add(value);
        }

        System.out.println();

        for(String e : relationships.get(user)) {
            int cnt = 0;
            while(cnt == relationships.get(e).size()){

                cnt++;
            }
        }

        return null;
    }
}
/*
*   그래프 형식으로 문제를 접근하여 풀어야할 것으로 사료 (미구현)
*
* */