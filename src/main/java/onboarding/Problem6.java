package onboarding;

import java.util.*;

import static onboarding.Problem6.Problem6Validation.validate;
import static onboarding.Util.sortListAscendingOrder;

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
        return validate(forms);
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
        return sortListAscendingOrder(new ArrayList<>(answerSet));
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
            for (int index = 0; index < currentNickname.length() - 1; index++) {
                if (form.get(NICKNAME_INDEX).contains(currentNickname.substring(index, index + 2))) {
                    repetitionSet.add(form.get(EMAIL_INDEX));
                    break;
                }
            }
        }
        return repetitionSet;
    }


    static abstract class Problem6Validation extends Validation {
        private static final int MIN_LIST_SIZE = 1;
        private static final int MAX_LIST_SIZE = 10000;

        public static boolean validate(List<List<String>> forms) {
            return validateListSizeRange(forms, MIN_LIST_SIZE, MAX_LIST_SIZE)
                    && validateEmailForm(forms)
                    && validateEmailDomain(forms)
                    && validateNicknameForm(forms);
        }
    }
}
