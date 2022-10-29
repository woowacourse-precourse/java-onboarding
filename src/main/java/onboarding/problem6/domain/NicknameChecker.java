package onboarding.problem6.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameChecker {

    public List<String> distinctSubString(String text) {
        return IntStream.range(0, text.length() - 1)
                .mapToObj(i -> text.substring(i, i + 2))
                .distinct()
                .collect(Collectors.toList());
    }
}
