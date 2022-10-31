package onboarding.domain.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MutualDictionaryGenerator {
    private final FriendRelations relations;
    private final String user;
    private final Map<String, Integer> dictionary;
    
    public MutualDictionaryGenerator(FriendRelations relations, String user) {
        this.user = user;
        this.relations = relations;
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
                dictionary.put(mutualFriend, countMutual(mutualFriend));
            }
        }
    }
    
    private int countMutual(String mutualFriend) {
        Integer count = dictionary.get(mutualFriend);
        return (count == null) ? 1 : ++count;
    }
}
