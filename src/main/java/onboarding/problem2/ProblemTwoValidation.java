package onboarding.problem2;

import static onboarding.problem2.LengthValue.MAX;
import static onboarding.problem2.LengthValue.MIN;

// TODO 유효하지 않은 데이터면 예외를 던지는게 좋을 듯하다.
//  클라이언트에서 예외 처리를 진행하면 좋을 거 같다.
public class ProblemTwoValidation {

    private String cryptogram;

    // cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
    //cryptogram은 알파벳 소문자로만 이루어져 있다.


    public ProblemTwoValidation(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public void checkedValid() {
        if (!isLowCase()) {
            throw new IllegalArgumentException("알파벳 소문자가 아닙니다.!!");
        }

        if (!isLength()) {
            throw new IllegalArgumentException("문자열의 범위가 유효하지 않습니다.");
        }
    }

    // 알파벳 소문자 검증
    private boolean isLowCase() {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!Character.isLowerCase(cryptogram.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // 문자열 길이 범위 검증
    public boolean isLength() {
        int length = this.cryptogram.length();

        // 제약 조건 문자열 길이가 1 이상 1000 이하다.
        if (is(length)) {
            return true;
        }

        return false;
    }

    private static boolean is(int length) {
        return (length >= MIN.getValue()) && (length <= MAX.getValue());
    }

}
