package onboarding.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MutualDictionaryGenerator {
    private final List<List<String>> relations;
    private final String user;
    public HashMap<String, Integer> dictionary;
    
    public MutualDictionaryGenerator(String user, List<List<String>> relations) {
        this.user = user;
        this.relations = relations;
        initDictionary();
    }
    
    private void initDictionary() {
        dictionary = new HashMap<String, Integer>();
        for (String friend : getAllFriendsByUser(user)) {
            List<String> mutualFriends = getAllFriendsByUser(friend);
            insertMutual(mutualFriends);
        }
    }
    
    private void insertMutual(List<String> mutualFriends) {
        for (String mutualFriend : mutualFriends) {
            if (isStranger(user, mutualFriend)) {
                dictionary.put(mutualFriend, getMutualCounts(mutualFriend));
            }
        }
    }
    
    private int getMutualCounts(String mutualFriend) {
        return (dictionary.containsKey(mutualFriend)) ? (dictionary.get(mutualFriend) + 1) : 1;
    }
    
    private List<String> getAllFriendsByUser(String user) {
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
    
    private boolean isFriend(String user1, String user2) {
        List<String> friends = getAllFriendsByUser(user1);
        return friends.contains(user2) ? true : false;
    }
    
    private boolean isStranger(String user1, String user2) {
        if (user1.equals(user2)) {
            return false;
        }
        if (isFriend(user1, user2)) {
            return false;
        }
        return true;
    }

}
