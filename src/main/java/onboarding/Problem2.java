package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDupl(cryptogram);
    }

    public static List<Integer> checkDupl(String cryptogram){
        int startIdx = 0;
        int endIdx = 0;
        boolean flag = false;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                if (flag == false) {
                    startIdx = i;
                }
                flag = true;
            } else {
                if (flag == true) {
                    endIdx = i;
                    break;
                }
            }
        }

        if (flag == true && startIdx >= endIdx) {
            endIdx = cryptogram.length() - 1;
        }
        return Arrays.asList(startIdx, endIdx);
    }

    public static String removeDupl(String cryptogram){
        List<Integer> duplIdx = checkDupl(cryptogram);
        int startIdx = duplIdx.get(0);
        int endIdx = duplIdx.get(1);
        String removeDuplStr;

        if (startIdx == 0 && endIdx == 0) {
            return cryptogram;
        }

        removeDuplStr = cryptogram.replaceAll(cryptogram.substring(startIdx, endIdx + 1), "");

        return removeDupl(removeDuplStr);
    }

}
