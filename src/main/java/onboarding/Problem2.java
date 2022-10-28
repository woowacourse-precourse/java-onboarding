package onboarding;

import org.intellij.lang.annotations.RegExp;

public class Problem2 {

    // 기능 요구 사항
    // TODO 중복 문자의 시작 인덱스를 리턴하는 메서드
    public static int getIndex(String cryptogram) {
        for (int i = 0; i <cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) return i;
        }
        return -1;
    }

    // TODO 중복 문자를 삭제하는 메서드
    public static String deleteCryptogram (String cryptogram) {

        return null;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}