package onboarding.problem7.collection;

import onboarding.problem7.validation.VisitorsValidator;

import java.util.List;
import java.util.function.Consumer;

public class Visitors {
    private final List<String> visitors;

    private Visitors(List<String> visitors) {
        this.visitors = visitors;
    }

    public static Visitors of(List<String> visitors) {
        VisitorsValidator.validate(visitors);
        return new Visitors(visitors);
    }

    public void forEach(Consumer<? super String> action) {
        visitors.forEach(action);
    }
}
