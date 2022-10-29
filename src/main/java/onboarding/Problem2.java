package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> splitCryptogram = new ArrayList<>(List.of(cryptogram.split("")));
        int codeIndex = 1;
        while (!decipherFinish(splitCryptogram, codeIndex)) {
            codeIndex = decipherCode(splitCryptogram, codeIndex);
        }
        return String.join("", splitCryptogram);
    }

    public static int decipherCode(List<String> code, int idx) {
        if (isDuplicate(code, idx)) {
            removeDuplicate(code, idx);
            idx = 0;
        }
        return idx + 1;
    }

    public static boolean decipherFinish(List<String> str, int idx) {
        return str.size() == idx || str.size() == 0;
    }

    public static boolean isDuplicate(List<String> str, int idx) {
        return str.get(idx-1).equals(str.get(idx));
    }

    public static void removeDuplicate(List<String> strList, int idx) {
        strList.remove(idx);
        strList.remove(idx-1);
    }
}
