/*
 * 클래스명: Problem7
 *
 * 시작 날짜: 2022-10-31
 */


package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        visitorsCount(visitors);

        return answer;
    }

    public static HashMap visitorsCount(List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < visitors.size(); i++) {
            String visitor = visitors.get(i);
            if (map.get(visitor) == null) {
                System.out.println("널 나옴");
                map.put(visitor, 1);
                continue;
            }
            map.put(visitor, map.get(visitor) + 1);
        }
        return map;
    }
}
