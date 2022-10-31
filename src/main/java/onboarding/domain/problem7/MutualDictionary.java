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

    public MutualDictionary(MutualDictionaryGenerator generator) {
        this.mutualDictionary = generator.getDictionary();
    }
    
    public Set<String> getAllMutuals() {
        return mutualDictionary.keySet();
    }
    
    public int getTotalMutualCounts(String mutualUser) {
        Integer count = mutualDictionary.get(mutualUser);
        return (count == null) ? 0 : count;
    }
}
