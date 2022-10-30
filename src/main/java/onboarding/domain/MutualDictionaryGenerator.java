package onboarding.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutualDictionaryGenerator {
    private final FriendRelations relations;
    private final String user;
    private final HashMap<String, Integer> dictionary;
    
    public MutualDictionaryGenerator(String user, List<List<String>> relations) {
        this.user = user;
        this.relations = new FriendRelations(relations);
        this.dictionary = new HashMap<String, Integer>();
        initDictionary();
    }
    
    public Map<String, Integer> getDictionary() {
        return dictionary;
    }
    
    private void initDictionary() {
        for (String friend : relations.getAllFriendsByUser(user)) {
            List<String> mutualFriends = relations.getAllFriendsByUser(friend);
            insertMutual(mutualFriends);
        }
    }
    
    private void insertMutual(List<String> mutualFriends) {
        for (String mutualFriend : mutualFriends) {
            if (relations.isStranger(user, mutualFriend)) {
                dictionary.put(mutualFriend, getMutualCounts(mutualFriend));
            }
        }
    }
    
    private int getMutualCounts(String mutualFriend) {
        return (dictionary.containsKey(mutualFriend)) ? (dictionary.get(mutualFriend) + 1) : 1;
    }
}
