package onboarding;

import static onboarding.problem2.Delete.executeDelete;
import static onboarding.problem2.Validation.isOutOfRange;
import static onboarding.problem2.Validation.checkValidForm;

public class Problem2 {
    private static final String INPUT_FORM_ERROR = "문자열 형식이 잘못되었습니다.";

    public static String solution(String cryptogram) {
        String answer = "answer";

        if (isOutOfRange(cryptogram)) {
            return INPUT_FORM_ERROR;
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            answer = checkValidForm(cryptogram.charAt(i));
        }

        if (INPUT_FORM_ERROR.equals(answer)) {
            return INPUT_FORM_ERROR;
        }

        answer = executeDelete(cryptogram);

        return answer;
    }
}
