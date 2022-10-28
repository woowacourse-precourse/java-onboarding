package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int FORM_MINIMUM_LENGTH = 1;
    private static final int FORM_MAXIMUM_LENGTH = 10000;
    private static final int Email_NICKNAME_MAXIMUM_LENGTH = 20;
    private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email\\.com";
    private static final String NICKNAME_PATTERN = "[가-힣]+";

    private static HashMap<String,Integer> all_two_letter = new HashMap<>();
    private static HashSet<String> nickname_repeated = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        if (!validateInput(forms)) return Collections.emptyList();

        makeAllTwoLetter(forms);

        checkNicknameRepeated(forms);

        return nickname_repeated.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void checkNicknameRepeated(List<List<String>> forms) {
        for (List<String> form : forms) {
            checkNicknameRepeatedAboutCrew(form);
        }
    }

    private static void checkNicknameRepeatedAboutCrew(List<String> form) {
        String email = form.get(0);
        String nickname = form.get(1);

        for (int i = 0; i < nickname.length() - 1; i++) {
            String two_letter = nickname.substring(i, i + 2);
            if (all_two_letter.get(two_letter) >= 2) {
                nickname_repeated.add(email);
                return;
            }
        }
    }

    private static void makeAllTwoLetter(List<List<String>> forms) {
        for (List<String> form : forms) {
            makeTwoLetterOfNickname(form.get(1));
        }
    }

    private static void makeTwoLetterOfNickname(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String two_letter = nickname.substring(i, i + 2);
            all_two_letter.put(two_letter, all_two_letter.getOrDefault(two_letter, 0)+1);
        }
    }

    private static boolean validateInput(List<List<String>> forms) {
        return validateCrewNum(forms)
                && validateEmailNickname(forms);
    }

    private static boolean validateCrewNum(List<List<String>> forms) {
        return forms.size() >= FORM_MINIMUM_LENGTH && forms.size() <= FORM_MAXIMUM_LENGTH;
    }

    private static boolean validateEmailNickname(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!validateEmail(form.get(0))) return false;
            if (!validateNickname(form.get(1))) return false;
        }
        return true;
    }

    private static boolean validateNickname(String nickname) {
        return Pattern.matches(NICKNAME_PATTERN, nickname)
                && nickname.length() < Email_NICKNAME_MAXIMUM_LENGTH;
    }

    private static boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_PATTERN, email)
                && email.length() < Email_NICKNAME_MAXIMUM_LENGTH;
    }

}