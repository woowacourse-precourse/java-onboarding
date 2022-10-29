package onboarding.domain.Problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private final Map<String, List<String>> relation;
    private final Map<String, Integer> score = new HashMap<>();

    public Score(Map<String, List<String>> relationTable) {
        relation = relationTable;
    }

    public int count(String person, String other) {
        int cnt=0;
        List<String> personFriends = relation.get(person);
        List<String> otherFriends = relation.get(other);
        for (String personFriend : personFriends) {
            cnt += addCnt(otherFriends, personFriend);
        }
        return cnt;
    }

    private static int addCnt(List<String> otherFriends, String personFriend) {
        int add = 0;
        for (String otherFriend : otherFriends) {
            if (personFriend.equals(otherFriend)) {
                add += 1;
            }
        }
        return add;
    }
}
