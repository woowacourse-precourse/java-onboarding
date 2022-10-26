package onboarding;

import java.util.ArrayList;
import java.util.List;


/**
 * a. 중복되지 않은 문자열만 저장하는 기능 구현
 *  a-1. 연속으로 중복되었는지 검사하는 기능 구현
 * */
public class Problem2 {

    public static String solution(String cryptogram) {
        return decipherCryptogram(cryptogram);
    }

    private static String decipherCryptogram(String cryptogram) {
        List<String> decipheringCryptogram = new ArrayList<>();

        for (String s : cryptogram.split("")) {
            int size = decipheringCryptogram.size();

            if (isDuplication(decipheringCryptogram, s)) {
                decipheringCryptogram.remove(size - 1);
                continue;
            }

            decipheringCryptogram.add(s);
        }

        return String.join("", decipheringCryptogram);
    }

    private static boolean isDuplication(List<String> decipheringCryptogram, String s) {
        int size = decipheringCryptogram.size();

        if (size == 0) {
            return false;
        }

        return decipheringCryptogram.get(size - 1).equals(s);
    }
}
