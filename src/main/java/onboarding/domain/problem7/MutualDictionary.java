package onboarding.domain.problem7;

import java.util.Map;
import java.util.Set;

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
