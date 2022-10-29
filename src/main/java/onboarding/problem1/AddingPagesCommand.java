package onboarding.problem1;

import java.util.List;

@FunctionalInterface
public interface AddingPagesCommand {
    void execute(Pager pager, List<Integer> pageNumbers);
}
