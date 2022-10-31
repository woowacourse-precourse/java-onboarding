package onboarding;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataValidationException;

public class Problem2 {
    public static String solution(String cryptogram) {
        checkList(cryptogram);

    }

    public static void checkList(String cryptogram) throws IllegalArgumentException {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new IllegalArgumentException("cryptogram은 길이가 1 미만 1000 초과인 문자열 입니다.");
        }
        if (cryptogram.toLowerCase() != cryptogram) {
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있지 않습니다.");
        }
        if (cryptogram.replaceAll(" ", "") != cryptogram) {
            throw new IllegalArgumentException("cryptogram에 공백이 있습니다.");
        }
    }
}



