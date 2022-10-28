package onboarding.problem7;

import java.util.List;

public class Visitors {

    private List<Visitor> visitors;

    protected Visitors() {

    }

    public Visitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public void add(Visitor visitor) {
        validateVisitorsSize();
        visitors.add(visitor);
    }

    private void validateVisitorsSize() {
        if (visitors.size() > 100000) {
            throw new IllegalStateException("Visitors의 크기는 10000이하어야 합니다.");
        }
    }
}
