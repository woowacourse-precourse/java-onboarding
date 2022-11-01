package onboarding.domain.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem number : 7
 * Comment : MutualDictionary 객체를 생성하는 기능을 대신 수행한다.
 * @author doyoung
 */
public class MutualDictionaryGenerator {
    private final FriendRelations relations;
    private final String user;
    private final Map<String, Integer> dictionary;
    
    public MutualDictionaryGenerator(String user, FriendRelations relations) {
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
                int count = dictionary.getOrDefault(mutualFriend, 0) + 1;
                dictionary.put(mutualFriend, count);
            }
        }
    }
}
