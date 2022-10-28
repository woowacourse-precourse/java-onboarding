package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;

    private static Map<String, List<String>> nicknameToTwoLetters = new HashMap();
    private static Map<String, String> nicknameToEmail = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        parseForms(forms);
        return findDuplicatedNicknameAndComputeEmail();
    }

    private static List<String> findDuplicatedNicknameAndComputeEmail() {
        return nicknameToTwoLetters.keySet()
            .stream()
            .filter(nickname -> isDuplicatedNicknames(nickname, nicknameToTwoLetters.get(nickname)))
            .map(nickname -> nicknameToEmail.get(nickname))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    private static boolean isDuplicatedNicknames(String baseNickname, List<String> baseTwoLetters) {
        return nicknameToTwoLetters.keySet()
            .stream()
            .filter(nickname -> nickname != baseNickname)
            .filter(nickname -> isDuplicatedTwoLetters(baseTwoLetters, nicknameToTwoLetters.get(nickname)))
            .count() != 0;
    }

    private static boolean isDuplicatedTwoLetters(List<String> twoLetters1, List<String> twoLetters2) {
        return twoLetters1.stream()
            .filter(twoLetter1 -> twoLetters2.contains(twoLetter1))
            .count() != 0;
    }

    private static void parseForms(List<List<String>> forms) {
        forms.forEach(man -> {
            String email = man.get(0);
            String nickname = man.get(1);
            List<String> twoLetters = computeTwoLetters(nickname);

            nicknameToTwoLetters.put(nickname, twoLetters);
            nicknameToEmail.put(nickname, email);
        });
    }

    private static List<String> computeTwoLetters(String input) {
        List<String> twoLetter = new ArrayList<>();

        IntStream.rangeClosed(0, input.length() - TWO)
            .forEach(i -> twoLetter.add(input.substring(i, i + TWO)));
        return twoLetter;
    }
}
