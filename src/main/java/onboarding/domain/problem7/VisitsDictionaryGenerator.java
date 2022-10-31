package onboarding.domain.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem number : 7
 * Comment : VisitsDictionary 객체를 생성하는 기능을 대신 수행한다.
 * @author doyoung
 */
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
            int count = dictionary.getOrDefault(visitor, 0) + 1;
            dictionary.put(visitor, count);
        }
    }
}
