package onboarding;

import onboarding.problem6.DuplicatedTokensCollector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        var tokens = forms.stream()
                .map(form -> form.get(1))
                .map(Problem6::splitNickname)
                .collect(new DuplicatedTokensCollector());
        return new ArrayList<>(forms.stream()
                .filter(form -> tokens.stream().anyMatch(token -> form.get(1).contains(token)))
                .collect(TreeSet<String>::new, (acc, form) -> acc.add(form.get(0)), TreeSet::addAll));
    }

    private static Set<String> splitNickname(String nickname) {
        return IntStream.rangeClosed(0, nickname.length() - 2)
                .mapToObj(i -> nickname.substring(i, i + 2))
                .collect(Collectors.toSet());
    }
}
