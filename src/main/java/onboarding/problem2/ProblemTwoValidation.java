package onboarding.problem2;

import org.assertj.core.util.Strings;

import static onboarding.problem2.LengthValue.*;

public class ProblemTwoValidation {

    private String cryptogram;

    public void settingCryptogram(String cryptogram) {
        // 널이 들어 오면 공백으로 대체
        this.cryptogram = cryptogram;
        if (Strings.isNullOrEmpty(cryptogram) || !isLength()) {
            this.cryptogram = "";
        }

        if (!isLowCase(cryptogram)) {
            this.cryptogram = this.cryptogram.toLowerCase();
        }
    }

    private boolean isLowCase(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!Character.isLowerCase(cryptogram.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getValidString() {
        return this.cryptogram;
    }

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
