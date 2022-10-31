package onboarding.problem7;

import java.lang.reflect.Array;
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
        ArrayList<String> friendsList = new ArrayList<>();
        for (int i = 0; i < relation.size(); i++) {
            List<String> friends = getRelation(i);
            if (friends.contains(user)) {
                friendsList.addAll(friends);
            }
        }
        List<String> resultList = Util.removeOverlap(friendsList);
        resultList.remove(user);
        return resultList;
    }
}
