package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        try {
            ExceptionProblem6.validateForms(forms);
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }

        HashSet<String> answer = new HashSet<>();

        for (List<String> form : forms) {

            String testEmail = form.get(0);
            String testName = form.get(1);

            for (int i = 0; i < testName.length() - 1 ; i++) {
                String test = testName.substring(i, i+2);

                for (List<String> formTest : forms) {

                    if (formTest.get(1).contains(test)) {

                        if (!formTest.get(0).equals(testEmail)) {
                            answer.add(formTest.get(0));
                        }

                    }

                }

            }
        }

        List<String> result = new ArrayList<>(answer);
        result.sort(String.CASE_INSENSITIVE_ORDER);

        return result;
    }
}
class ExceptionProblem6 {
    public static void validateForms(List<List<String>> forms) {
        for (List<String> form : forms) {
            conformEmailFormat(form.get(0));
            validateEmailLength(form.get(0));
            validateKoreanNickname(form.get(1));
            validateNicknameLength(form.get(1));
        }
    }

    private static void conformEmailFormat(String email) {
        String format = "@email.com";
        if (!email.contains(format)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEmailLength(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateKoreanNickname(String nickname) {
        String regExp = "^[가-힣]*$";
        if (!nickname.matches(regExp)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNicknameLength(String nickname) {
        if (nickname.length() < 1 || nickname.length() >= 20) {
            throw new IllegalArgumentException();
        }
    }

}
