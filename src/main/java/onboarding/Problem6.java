package onboarding;

import onboarding.problem6.Crew;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Problem6 {
    static Set<String> usingNickname;
    static Set<String> limitedWords;
    static List<String> words;

    public static List<String> solution(List<List<String>> forms) {
        usingNickname = new HashSet<>();
        limitedWords = new HashSet<>();
        words = new ArrayList<>();

        if (forms.size() < 1 || forms.size() > 10000) {
            return Collections.emptyList();
        }

        forms.forEach(Problem6::registerNickname);

        return forms.stream()
                .map(Crew::new)
                .filter(Problem6::isDuplicatedName)
                .map(crew -> crew.getEmail().getValue())
                .sorted(Comparator.naturalOrder())
                .distinct()
                .collect(Collectors.toList());
    }

    private static void registerNickname(List<String> form) {
        String nickname = form.get(1);

        splitNickname(nickname).stream()
                .filter(word -> !usingNickname.add(word))
                .forEach(limitedWords::add);
    }

    private static boolean isDuplicatedName(Crew crew) {
        String nickname = crew.getNickname().getValue();

        return splitNickname(nickname).stream()
                .anyMatch(limitedWords::contains);
    }

    private static List<String> splitNickname(String nickname) {
        words.clear();

        for (int i = 0; i < nickname.length() - 1; i++) {
            words.add(nickname.substring(i, i + 2));
        }

        return words;
    }
}
