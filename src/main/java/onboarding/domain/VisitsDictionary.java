package onboarding.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitsDictionary {
    private final Map<String, Integer> visitDictionary;
    
    public VisitsDictionary(List<String> visitors) {
        this.visitDictionary = new HashMap<String, Integer>();
    }
    
//    public int getVisitCount(String user) {
//        int count = 0;
//        for (String visitor : visitors) {
//            count += (user.equals(visitor)) ? 1 : 0;
//        }
//        return count;
//    }
}
