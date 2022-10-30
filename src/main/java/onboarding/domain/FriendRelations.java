package onboarding.domain;

import java.util.ArrayList;
import java.util.List;

public class FriendRelations {
    private final List<List<String>> friendRelations;
    
    public FriendRelations(List<List<String>> friendRelations) {
        this.friendRelations = friendRelations;
    }

    public List<String> getAllFriendsByUser(String user) {
        List<String> friends = new ArrayList<>();
        for (List<String> relation : friendRelations) {
            String result = searchFriendByUser(user, relation);
            if (!result.isEmpty()) {
                friends.add(result);
            }
        }
        return friends;
    }
    
    private String searchFriendByUser(String user, List<String> relation) {
        if (relation.contains(user)) {
            String x = relation.get(0), y = relation.get(1);
            return (user.equals(x)) ? y : x; 
        }
        return "";
    }
}
