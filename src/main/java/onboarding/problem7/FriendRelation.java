package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FriendRelation {

    private HashMap<String, List<String>> relations = new HashMap<>();

    public FriendRelation(List<List<String>> friends) {
        initRelations(friends);
    }

    private void initRelations(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String first = friend.get(0);
            String second = friend.get(1);
            List<String> firstFriends = relations.getOrDefault(first, new ArrayList<>());
            List<String> secondFriends = relations.getOrDefault(second, new ArrayList<>());
            firstFriends.add(second);
            secondFriends.add(first);
            relations.put(first, firstFriends);
            relations.put(second, secondFriends);
        }
    }

    public HashMap<String, List<String>> getRelations() {
        return relations;
    }
}
