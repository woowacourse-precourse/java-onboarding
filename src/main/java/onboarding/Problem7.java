package onboarding;

import java.util.Collections;
import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //친구들 점수를 나타내는 해시테이블 생성
        Map<String, Integer> scoreTable = makeHashTable(user, friends);

        // 친구들 중 사용자와 연결된 사람에게 10점을 추가해 주는 기능
        keepScore(user, scoreTable, friends);

        // visitors에게 각각 1점씩 주는 기능
        keepScoreToVisitors(scoreTable, visitors);

        System.out.println(scoreTable);

        return answer;
    }

    public static void keepScoreToVisitors(Map<String, Integer> scoreTable, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            String name = visitors.get(i);
            System.out.println(name);
            if (scoreTable.get(name) == null) {
                scoreTable.put(name, 1);
                continue;
            }
            Integer score = scoreTable.get(name);
            scoreTable.put(name, score + 1);
        }
    }

    public static void keepScore(String user, Map<String, Integer> scoreTable, List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            String person1 = friends.get(i).get(0);
            String person2 = friends.get(i).get(1);
            if (person1.equals(user)){
                Integer nextScore = scoreTable.get(person2) + 10;
                scoreTable.put(person2, nextScore);
            }
            if (person2.equals(user)){
                Integer nextScore = scoreTable.get(person1) + 10;
                scoreTable.put(person1, nextScore);
            }
        }
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
