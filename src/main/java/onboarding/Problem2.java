package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplicate(cryptogram);

        while (isDuplicate(cryptogram)) {   // 중복 문자가 없을 때까지 반복
            cryptogram = removeDuplicate(cryptogram);
        }

        return cryptogram;
    }

    //중복 문자를 제거하는 기능
    public static String removeDuplicate(String cryptogram) {

        List<String> duplicateCharacters = new ArrayList<>();

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                duplicateCharacters.add(cryptogram.substring(i, (getCutIndex(cryptogram.substring(i)) + i + 1)));
                i = getCutIndex(cryptogram.substring(i)) + i;
            }
        }

        for (String duplicateCharacter : duplicateCharacters) {
            System.out.println(duplicateCharacter);
            if (cryptogram.contains(duplicateCharacter))
                cryptogram = cryptogram.replaceAll(duplicateCharacter, "");
        }

        return cryptogram;
    }

    // 중복 문자가 존재하는지 체크하는 기능
    public static boolean isDuplicate(String cryptogram) {
        for (int i = 0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return true;
        }
        return false;
    }

    // 몇 번째 인덱스까지 연속된 문자가 나오는지 확인하는 기능
    public static int getCutIndex(String str) {
        int cutIndex = 0;

        for (int i = 0; i < str.length() - 1; i++){
            if (str.charAt(i) == str.charAt(i+1) && str.charAt(0) == str.charAt(i)) {
                cutIndex = i+1;
            }
        }
        return cutIndex;
    }
}