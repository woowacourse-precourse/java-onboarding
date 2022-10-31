package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        if (!validateInput(forms)) {
            return null;
        }
        return calculateAnswer(new ArrayList<>(forms));
    }

    private static boolean validateInput(List<List<String>> forms) {
        return Validation.validate(forms);
    }

    private static List<String> calculateAnswer(ArrayList<List<String>> forms) {
        Set<String> answerSet = new HashSet<>();

        for (Iterator<List<String>> form = forms.iterator(); form.hasNext(); ) {
            List<String> currentForm = form.next();
            Set<String> repetitionSet = calculateRepetition(forms, currentForm.get(NICKNAME_INDEX));

            if (repetitionSet != null && !repetitionSet.isEmpty()) {
                answerSet.addAll(repetitionSet);
                answerSet.add(currentForm.get(EMAIL_INDEX));
                form.remove();
            }
        }
        return new ArrayList<>(answerSet);
    }

    private static Set<String> calculateRepetition(List<List<String>> forms, String currentNickname) {
        if (currentNickname.length() == 1) {
            return null;
        }
        Set<String> repetitionSet = new HashSet<>();

        for (List<String> form : forms) {
            if (form.get(NICKNAME_INDEX).equals(currentNickname) || form.get(NICKNAME_INDEX).length() == 1) {
                continue;
            }
            for (int index = 0; index < currentNickname.length() - 2; index++) {
                if (form.get(NICKNAME_INDEX).contains(currentNickname.substring(index, index + 2))) {
                    repetitionSet.add(form.get(EMAIL_INDEX));
                    break;
                }
            }
        }
        return repetitionSet;
    }

    static abstract class Validation {

        private static final int MIN_LIST_SIZE = 1;
        private static final int MAX_LIST_SIZE = 10000;
        private static final int MIN_EMAIL_LENGTH = 11;
        private static final int MAX_EMAIL_LENGTH = 19;
        private static final int MIN_NICKNAME_LENGTH = 1;
        private static final int MAX_NICKNAME_LENGTH = 19;
        private static final String EMAIL_FORM_REGEX = "^(.+)@(.+)$";
        private static final String NICKNAME_FORM_REGEX = "^[가-힣]*$";
        private static final String EMAIL_DOMAIN = "email.com";


        public static boolean validate(List<List<String>> forms) {
            return validateListSize(forms)
                    && validateEmailForm(forms)
                    && validateEmailDomain(forms)
                    && validateNicknameForm(forms);
        }

        private static boolean validateListSize(List<List<String>> forms) {
            return forms.size() >= MIN_LIST_SIZE
                    && forms.size() <= MAX_LIST_SIZE;
        }

        private static boolean validateEmailForm(List<List<String>> forms) {
            for (List<String> form : forms) {
                String email = form.get(0);
                if (!email.matches(EMAIL_FORM_REGEX)) {
                    return false;
                }
                if (email.length() <= MIN_EMAIL_LENGTH || email.length() >= MAX_EMAIL_LENGTH) {
                    return false;
                }
            }
            return true;
        }

        private static boolean validateEmailDomain(List<List<String>> forms) {
            for (List<String> form : forms) {
                String email = form.get(0);
                if (!email.endsWith(EMAIL_DOMAIN)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean validateNicknameForm(List<List<String>> forms) {
            for (List<String> form : forms) {
                String nickname = form.get(1);
                if (!nickname.matches(NICKNAME_FORM_REGEX)) {
                    return false;
                }
                if (nickname.length() <= MIN_NICKNAME_LENGTH || nickname.length() >= MAX_NICKNAME_LENGTH) {
                    return false;
                }
            }
            return true;
        }
    }
}
