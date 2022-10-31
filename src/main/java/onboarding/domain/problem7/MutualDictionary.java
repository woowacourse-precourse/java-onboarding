package onboarding.domain.problem7;

import java.util.Map;
import java.util.Set;

/**
 * 
 * Problem number : 7
 * Comment : 한 사용자에 대한 친구의 친구 정보를 key=아이디, value=함께 아는 친구의 수 형식으로 제공한다.
 * @author doyoung
 */
public class MutualDictionary {
    private final Map<String, Integer> mutualDictionary;

    public MutualDictionary(FriendRelations relations, String user) {
        this.mutualDictionary = new MutualDictionaryGenerator(relations, user).getDictionary();
    }
    
    public Set<String> getAllMutuals() {
        return mutualDictionary.keySet();
    }
    
    public int getTotalMutualCounts(String mutualUser) {
        return mutualDictionary.getOrDefault(mutualUser, 0);
    }
}
