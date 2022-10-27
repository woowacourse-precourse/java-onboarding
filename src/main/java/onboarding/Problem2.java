package onboarding;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        int cryptoLength = cryptogram.length();
        String answer = cryptogram;
        String removeCryptogram = cryptogram;

        for (int i = 0; i < cryptoLength; i++) {
            removeCryptogram = duplicateRemove(answer, i);
            if (!answer.equals(removeCryptogram)) {
                answer = removeCryptogram;
                cryptoLength = answer.length();
                i = -1; // 첫 번째 문장부터 다시 검사하기 위한 초기화 끝나면 i++이 되기 때문에 i = -1이어야함
            }
        }

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
