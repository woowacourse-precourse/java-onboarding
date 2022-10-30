package onboarding.domain;

import java.util.List;

public class Visitors {
    private final List<String> visitors;
    
    public Visitors(List<String> visitors) {
        this.visitors = visitors;
    }
    
    public int getVisitCount(String user) {
        int count = 0;
        for (String visitor : visitors) {
            count += (user.equals(visitor)) ? 1 : 0;
        }
        return count;
    }
}
