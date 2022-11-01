package onboarding;

import java.util.Collections;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //친구들 점수를 나타내는 해시테이블 생성
        Map<String, Integer> scoreTable = makeHashTable(user, friends);
        System.out.println(scoreTable);
        return answer;
    }

    public static Map<String, Integer> makeHashTable(String user, List<List<String>> friends) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < 2; j++) {
                String person = friends.get(i).get(j);
                if (!person.equals(user)) {
                    map.put(person, 0);
                }
            }
        }
        return map;
    }

}
