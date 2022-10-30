package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem6 {

    private static final int TWO = 2;

    //    private static final int STUDENT_NUM_MIN = 1;
    //    private static final int STUDENT_NUM_MAX = 10000;
    //    private static final String EMAIL_REGEX = "^[[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*]{1,9}@email.com$";
    //    private static final String NICKNAME_REGEX = "^[ㄱ-ㅎ|가-힣|]{1,19}$";
    //
    //    private static Map<String, List<String>> nicknameToTwoLetters = new HashMap();
    //    private static Map<String, String> nicknameToEmail = new HashMap<>();
    //
    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> nicknameAndTwoLetters = computeAllTwoLetters(forms);
        return null;
        //        validateForms(forms);
        //        parseForms(forms);
        //        return findDuplicatedNicknameAndComputeEmail();
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

    //
    //    private static void validateForms(List<List<String>> forms) {
    //        if (isValidFormSize(forms) && isValidFormEmail(forms) && isValidFormNickname(forms)) {
    //            return;
    //        }
    //        throw new IllegalArgumentException();
    //    }
    //
    //    private static boolean isValidFormSize(List<List<String>> forms) {
    //        return forms.size() >= STUDENT_NUM_MIN && forms.size() <= STUDENT_NUM_MAX;
    //    }
    //
    //    private static boolean isValidFormEmail(List<List<String>> forms) {
    //        return forms.stream()
    //            .filter(form -> !Pattern.matches(EMAIL_REGEX, form.get(0)))
    //            .count() == 0;
    //    }
    //
    //    private static boolean isValidFormNickname(List<List<String>> forms) {
    //        return forms.stream()
    //            .filter(form -> !Pattern.matches(NICKNAME_REGEX, form.get(1)))
    //            .count() == 0;
    //    }
    //
    //    private static List<String> findDuplicatedNicknameAndComputeEmail() {
    //        return nicknameToTwoLetters.keySet()
    //            .stream()
    //            .filter(nickname -> isDuplicatedNicknames(nickname, nicknameToTwoLetters.get(nickname)))
    //            .map(nickname -> nicknameToEmail.get(nickname))
    //            .distinct()
    //            .sorted()
    //            .collect(Collectors.toList());
    //    }
    //
    //    private static boolean isDuplicatedNicknames(String baseNickname, List<String> baseTwoLetters) {
    //        return nicknameToTwoLetters.keySet()
    //            .stream()
    //            .filter(nickname -> nickname != baseNickname)
    //            .filter(nickname -> isDuplicatedTwoLetters(baseTwoLetters, nicknameToTwoLetters.get(nickname)))
    //            .count() != 0;
    //    }
    //
    //    private static boolean isDuplicatedTwoLetters(List<String> twoLetters1, List<String> twoLetters2) {
    //        return twoLetters1.stream()
    //            .filter(twoLetter1 -> twoLetters2.contains(twoLetter1))
    //            .count() != 0;
    //    }
    //
    //    private static void parseForms(List<List<String>> forms) {
    //        forms.forEach(man -> {
    //            String email = man.get(0);
    //            String nickname = man.get(1);
    //            List<String> twoLetters = computeTwoLetters(nickname);
    //
    //            nicknameToTwoLetters.put(nickname, twoLetters);
    //            nicknameToEmail.put(nickname, email);
    //        });
    //    }
    //
    //    private static List<String> computeTwoLetters(String input) {
    //        List<String> twoLetter = new ArrayList<>();
    //
    //        IntStream.rangeClosed(0, input.length() - TWO)
    //            .forEach(i -> twoLetter.add(input.substring(i, i + TWO)));
    //        return twoLetter;
    //    }
}
