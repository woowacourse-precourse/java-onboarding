package onboarding;

import onboarding.problem6.Crew;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.stream.Stream;

public class Problem6 {
    static final Set<String> usingNickname = new HashSet<>();
    static final Set<String> limitedWords = new HashSet<>();
    static final List<String> words = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if (forms.size() < 1 || forms.size() > 10000) {
            return Collections.emptyList();
        }

        forms.forEach(Problem6::registerNickname);

        Stream<Crew> crewStream = forms.stream()
                .map(Crew::new)
                .filter(Problem6::isDuplicatedName);

        return answer;
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
