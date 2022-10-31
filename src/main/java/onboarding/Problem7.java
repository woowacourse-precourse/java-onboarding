package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem7 {
    private static final int MUTUAL_SCORE = 10;
    private static final int VISIT_SCORE = 1;



    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<List<String>> friendRelations = new ArrayList<>();
        HashSet<String> userFriends = new HashSet<>();

        for (List<String> friendRelation : friends) { // friends 중에 user와 친구인 항목 제외
            if (friendRelation.contains(user)) {
                userFriends.add(friendRelation.get(0));
            } else {
                friendRelations.add(friendRelation);
            }
        }

        List<String> answer = Collections.emptyList();
        return answer;
    }
}
