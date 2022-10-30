package onboarding;

import static onboarding.problem4.Transformation.getWord;
import static onboarding.problem4.Validation.isOutOfRange;

public class Problem4 {
    private static final String INPUT_FORM_ERROR = "문자열 형식이 잘못되었습니다.";

    public static String solution(String word) {
        if(isOutOfRange(word)) {
            return INPUT_FORM_ERROR;
        }

        return getWord(word);
    }
}
