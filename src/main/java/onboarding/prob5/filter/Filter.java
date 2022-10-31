package onboarding.prob5.filter;

import java.util.List;

public abstract class Filter {
    private final Filter nextFilter;
    protected Filter(Filter filter) {
        this.nextFilter = filter;
    }
    public List<Integer> resolve(int amount, List<Integer> changes) {
        if (nextFilter != null) {
            nextFilter.resolve(amount, changes);
        }
        return changes;
    }
}