package onboarding.problem7;

import java.util.List;

public class Visitor {
    private final List<User> visitor;

    public Visitor(List<User> visitor) {
        this.visitor = visitor;
    }

    public List<User> toList() {
        return visitor;
    }

}