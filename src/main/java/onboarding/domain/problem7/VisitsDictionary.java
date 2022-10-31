package onboarding.domain.problem7;

import java.util.Map;
import java.util.Set;

public class VisitsDictionary {
    private final Map<String, Integer> visitsDictionary;
    
    public VisitsDictionary(VisitsDictionaryGenerator generator) {
        this.visitsDictionary = generator.getDictionary();
    }
    
    public Set<String> getAllVisitors() {
        return visitsDictionary.keySet();
    }
    
    public int getTotalVisitCounts(String visitor) {
        Integer count = visitsDictionary.get(visitor);
        return (count == null) ? 0 : count;
    }
}
