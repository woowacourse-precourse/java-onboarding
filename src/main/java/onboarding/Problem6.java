package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nicknameToTwoLetters = new HashMap();
        Map<String, String> nicknameToEmail = new HashMap<>();
        Set<String> twoLettersSet = new HashSet<>();
        List<String> answer = new ArrayList<>();

        forms.forEach(man -> {
            String email = man.get(0);
            String nickname = man.get(1);
            List<String> twoLetters = computeTwoLetters(nickname);

            nicknameToTwoLetters.put(nickname, twoLetters);
            nicknameToEmail.put(nickname, email);
            twoLetters.forEach(twoLetter -> twoLettersSet.add(twoLetter));
        });

        nicknameToTwoLetters.forEach((baseNickname, baseTwoLetters) -> {
            nicknameToTwoLetters.forEach((nickname, twoLetters) -> {
                if (baseNickname.equals(nickname)) {
                    return;
                }
                if (baseTwoLetters.stream()
                    .filter(baseTwoLetter -> twoLetters.contains(baseTwoLetter))
                    .count() != 0) {
                    answer.add(nicknameToEmail.get(baseNickname));
                }
            });
        });
        return answer.stream()
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    private static List<String> computeTwoLetters(String input) {
        List<String> twoLetter = new ArrayList<>();

        IntStream.rangeClosed(0, input.length() - TWO)
            .forEach(i -> twoLetter.add(input.substring(i, i + TWO)));
        return twoLetter;
    }
}
