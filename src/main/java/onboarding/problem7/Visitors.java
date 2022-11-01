package onboarding.problem7;

import onboarding.problem7.exception.VisitorArrayOutOfSizeException;

import java.util.ArrayList;
import java.util.List;

public class Visitors {
    private static final int MIN_VISITOR_SIZE = 0;
    private static final int MAX_VISITOR_SIZE = 10_000;
    private final List<String> visitors;

    public Visitors(List<String> visitors){
        this.visitors = visitors;
    }

    public List<String> getVisitors() {
        validateVisitor();
        return new ArrayList<>(visitors);
    }

    private void validateVisitor(){
        if(visitors.size() < MIN_VISITOR_SIZE || visitors.size() > MAX_VISITOR_SIZE) {
            throw new VisitorArrayOutOfSizeException();
        }
    }


}
