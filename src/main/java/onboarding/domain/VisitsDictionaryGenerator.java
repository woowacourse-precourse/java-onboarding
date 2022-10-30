package onboarding.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitsDictionaryGenerator {
    private final FriendRelations relations;
    private final String user;
    private final List<String> visitors;
    private final Map<String, Integer> dictionary;
    
    public VisitsDictionaryGenerator(FriendRelations relations, String user, List<String> visitors) {
        this.relations = relations;
        this.user = user;
        this.visitors = visitors;
        this.dictionary = new HashMap<String, Integer>();
        initDictionary();
    }
    
    public Map<String, Integer> getDictionary() {
        return dictionary;
    }
    
    private void initDictionary() {
        for (String visitor : visitors) {
            insertCount(visitor);
        }
    }
    
    private void insertCount(String visitor) {
        if (relations.isStranger(user, visitor)) {
            Integer value = dictionary.get(visitor);
            int count = (value == null) ? 1 : ++value;
            dictionary.put(visitor, count);
        }
    }
}
