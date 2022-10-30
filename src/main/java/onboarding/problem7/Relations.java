package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Relations {
    private List<List<String>> relation;

    Relations(List<List<String>> relation) {
        this.relation = relation;
    }

    public int size() {
        return relation.size();
    }

    public List<String> getRelation(int index) {
        return relation.get(index);
    }
    public List<String> getDistinctFriends() {
        List<String> forJoin = new ArrayList<>();
        for (int i = 0; i < relation.size(); i++) {
            List<String> relation = getRelation(i);
            forJoin.addAll(relation);
        }
        Set<String> distinctSet = new HashSet<>(forJoin);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }

    public List<String> getFriendsList(String user) {
        List<String> friendsList = new ArrayList<>();
        for (int i = 0; i < relation.size(); i++) {
            List<String> friends = getRelation(i);
            String friend1 = friends.get(0);
            String friend2 = friends.get(1);

            if (friend1.equals(user)) {
                friendsList.add(friend2);
            } else if (friend2.equals(user)) {
                friendsList.add(friend1);
            }
        }
        return friendsList;
    }
}
