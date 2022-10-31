package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Visitors {
    private final List<String> visitors;
    Visitors(List<String> visitors) {
        this.visitors = visitors;
    }
    public List<String> getDistinctVisitors() {
        Set<String> distinctSet = new HashSet<>(visitors);
        List<String> distinctList = new ArrayList<>(distinctSet);
        return distinctList;
    }
}
