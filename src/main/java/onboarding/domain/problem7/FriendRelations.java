package onboarding.domain.problem7;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem number : 7
 * Comment : 전체 사용자에 대한 친구 관계 정보를 제공한다.
 * @author doyoung
 */
public class FriendRelations {
    private final List<List<String>> relations;
    
    public FriendRelations(List<List<String>> relations) {
        this.relations = relations;
    }
    
    public List<String> getAllFriendsByUser(String user) {
        List<String> friends = new ArrayList<>();
        for (List<String> relation : relations) {
            String friend = extractFriendId(user, relation);
            if (!friend.isEmpty()) {
                friends.add(friend);
            }
        }
        return friends;
    }
    
    private String extractFriendId(String user, List<String> relation) {
        if (relation.contains(user)) {
            String x = relation.get(0), y = relation.get(1);
            return (user.equals(x)) ? y : x; 
        }
        return "";
    }
    
    public boolean isStranger(String user1, String user2) {
        if (user1.equals(user2)) {
            return false;
        }
        if (isFriend(user1, user2)) {
            return false;
        }
        return true;
    }
    
    private boolean isFriend(String user1, String user2) {
        List<String> friends = getAllFriendsByUser(user1);
        return friends.contains(user2) ? true : false;
    }
}
