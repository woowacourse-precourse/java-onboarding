package onboarding.domain.problem7;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Problem number : 7
 * Comment : 한 사용자에 대한 방문자 정보를 key=아이디, value=방문한 횟수 형식으로 제공한다.
 * @author doyoung
 */
public class VisitsDictionary {
    private final Map<String, Integer> visitsDictionary;
    
    public VisitsDictionary(String user, FriendRelations relations, List<String> visitors) {
        this.visitsDictionary = new VisitsDictionaryGenerator(user, relations, visitors).getDictionary();
    }
    
    public Set<String> getAllVisitors() {
        return visitsDictionary.keySet();
    }
    
    public int getTotalVisitCounts(String visitor) {
        return visitsDictionary.getOrDefault(visitor, 0);
    }
}
