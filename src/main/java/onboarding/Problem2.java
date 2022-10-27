package onboarding;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String duplicateRemove(String cryptogram, int index) {

        String[] splitCryptogram = cryptogram.split("");
        boolean isDuplicate = false;

        for (int i = index + 1; i < splitCryptogram.length; i++) {
            if (!splitCryptogram[i].equals(splitCryptogram[index])) {
                break;
            }
            splitCryptogram[i] = "";
            isDuplicate = true;
        }

        if (isDuplicate == true) {
            splitCryptogram[index] = "";
        }

        return String.join("", splitCryptogram);
    }
}
