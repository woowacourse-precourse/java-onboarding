package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 기능 목록
 * 1. cryptogram을 하나씩 잘라 List로 변환하는 기능
 * 2. 해독되었는지 확인하는 기능
 * 3. 연속적으로 중복된 문자를 모두 삭제하는 기능
 * 4. 중복된 문자를 삭제하는 기능
 * 5. answer에 잘라뒀던 문자열을 붙이는 기능
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        //cryptogram을 하나씩 잘라 List로 변환하는 기능
        List<String> subCryptograms = new ArrayList<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            subCryptograms.add(cryptogram.substring(i, i + 1));
        }

        return answer;
    }

    // 해독되었는지 확인하는 기능
    private static boolean isDecoded(List<String> subCryptograms) {
        for (int i = 0; i < subCryptograms.size()-1; i++) {
            if (subCryptograms.get(i).equals(subCryptograms.get(i + 1))) {
                return false;
            }
        }
        return true;
    }
}
