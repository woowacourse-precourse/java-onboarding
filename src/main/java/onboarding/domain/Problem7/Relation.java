package onboarding.domain.Problem7;

import java.util.*;

public class Relation {

    private final Map<String, List<String>> relation;

    public Relation(List<List<String>> friends) {
        relation = makeRelationTable(friends);
    }
    public Set<String> nameList() {
        return relation.keySet();
    }

    private Map<String, List<String>> makeRelationTable(List<List<String>> friends) {
        Map<String,List<String>> relation = new HashMap<>();
        for (List<String> twoFriends : friends) {
            if (!relation.containsKey(twoFriends.get(0)))
                relation.put(twoFriends.get(0), new ArrayList<>());
            if (!relation.containsKey(twoFriends.get(1)))
                relation.put(twoFriends.get(1), new ArrayList<>());
            relation.get(twoFriends.get(0)).add(twoFriends.get(1));
            relation.get(twoFriends.get(1)).add(twoFriends.get(0));
        }
        return relation;
    }

    public int countAcquaintance(String user, String other) {
        return (int) relation.get(other).stream()
                .filter(otherFriend->relation.get(user).contains(otherFriend))
                .count();
    }

    public List<String> friendOf(String user) {
        return relation.get(user);
    }
}
