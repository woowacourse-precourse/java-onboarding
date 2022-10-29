package onboarding.problem1;

import onboarding.problem1.gradable.Gradable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pager implements Function<Gradable, List<Integer>> {
    private final List<List<Integer>> pages = new ArrayList<>();

    public void addPages(List<Integer> pageNumbers) {
        pages.add(pageNumbers);
    }

    @Override
    public List<Integer> apply(Gradable gradable) {
        return pages.stream()
                .map(gradable::grade)
                .collect(Collectors.toList());
    }
}
