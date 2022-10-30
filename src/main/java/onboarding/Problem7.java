package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> relation_position = null;
        String f1, f2;


        for (int i=0; i<friends.size(); i++) {

            f1 = friends.get(i).get(0);
            f2 = friends.get(i).get(1);

            if (relation_position.containsKey(f1)) relation_position.get(f1).add(f2);
            if (relation_position.containsKey(f2)) relation_position.get(f2).add(f1);

        }

        return answer;
    }
}
