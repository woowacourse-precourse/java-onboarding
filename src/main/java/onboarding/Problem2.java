package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static String solution(String cryptogram) {
        try {
            validation(cryptogram);

            String answer = decode(cryptogram);
            return answer;
        } catch (RuntimeException e) {
            throw e;
        }

    }

    public static String deduplicate(String text) {
        char fivot;
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            fivot = text.charAt(i);
            Boolean duplicateFlag = false;
            while (i < text.length() - 1 && fivot == text.charAt(i + 1)) {
                i++;
                duplicateFlag = true;
            }
            if (!duplicateFlag) {
                newText.append(fivot);
            }
        }
        return newText.toString();
    }

    public static String decode(String cryptogram) {

        String code = cryptogram;
        String plain;

        while (true) {
            plain = deduplicate(code);

            if (code.equals(plain)) {
                break;
            }
            code = plain;
        }
        return plain;
    }

    public static void validation(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new RuntimeException("글자 수는 1이상 1000 이하여야 합니다.");
        }
    }

}
