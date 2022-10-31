package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;
    private static final int STUDENT_NUM_MIN = 1;
    private static final int STUDENT_NUM_MAX = 10000;
    private static final String EMAIL_REGEX = "^[0-9a-zA-Z(-_.?0-9a-zA-Z)*]{1,9}@email.com$";
    private static final String NICKNAME_REGEX = "^[ㄱ-ㅎ|가-힣|ㅏ-ㅣ|]{1,19}$";

    public static List<String> solution(List<List<String>> forms) {
        validateForms(forms);
        Map<String, List<String>> nicknameAndTwoLetters = computeAllTwoLetters(forms);
        List<String> duplicatedNicknameList = findDuplicatedNickname(nicknameAndTwoLetters);

        return computeAnswer(duplicatedNicknameList, forms);
    }

    private static void validateForms(List<List<String>> forms) {
        if (isValidFormSize(forms) && isValidFormEmail(forms) && isValidFormNickname(forms)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isValidFormSize(List<List<String>> forms) {
        return forms.size() >= STUDENT_NUM_MIN && forms.size() <= STUDENT_NUM_MAX;
    }

    private static boolean isValidFormEmail(List<List<String>> forms) {
        return forms.stream()
            .allMatch(form -> Pattern.matches(EMAIL_REGEX, form.get(0)));
    }

    private static boolean isValidFormNickname(List<List<String>> forms) {
        return forms.stream()
            .allMatch(form -> Pattern.matches(NICKNAME_REGEX, form.get(1)));
    }

    private static List<String> computeAnswer(List<String> duplicatedNicknameList, List<List<String>> forms) {
        return forms.stream()
            .filter(form -> duplicatedNicknameList.contains(form.get(1)))
            .map(form -> form.get(0))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    private static List<String> findDuplicatedNickname(Map<String, List<String>> nicknameAndTwoLetters) {
        return nicknameAndTwoLetters.entrySet()
            .stream()
            .filter(nicknameAndTwoLettersMap -> isDuplicatedNickname(nicknameAndTwoLetters, nicknameAndTwoLettersMap.getKey(), nicknameAndTwoLettersMap.getValue()))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private static boolean isDuplicatedNickname(Map<String, List<String>> nicknameAndTwoLetters, String baseNickname, List<String> baseTwoLetters) {
        return nicknameAndTwoLetters.keySet()
            .stream()
            .filter(nickname -> !nickname.equals(baseNickname))
            .anyMatch(nickname -> isDuplicatedTwoLetters(baseTwoLetters, nicknameAndTwoLetters.get(nickname)));
    }

    private static boolean isDuplicatedTwoLetters(List<String> twoLetters1, List<String> twoLetters2) {
        return twoLetters1.stream()
            .anyMatch(twoLetters2::contains);
    }

    private static Map<String, List<String>> computeAllTwoLetters(List<List<String>> forms) {
        Map<String, List<String>> nicknameAndTwoLetters = new HashMap<>();

        forms.forEach(man -> {
            String nickname = man.get(1);
            List<String> twoLetters = computeTwoLetters(nickname);

            nicknameAndTwoLetters.put(nickname, twoLetters);
        });
        return nicknameAndTwoLetters;
    }

    private static List<String> computeTwoLetters(String nickname) {
        List<String> twoLetter = new ArrayList<>();

        IntStream.rangeClosed(0, nickname.length() - TWO)
            .forEach(i -> twoLetter.add(nickname.substring(i, i + TWO)));
        return twoLetter;
    }
}
