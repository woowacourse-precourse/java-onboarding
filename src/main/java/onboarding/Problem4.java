package onboarding;

import onboarding.problem4.FrogDictionary;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    /*
    기능목록
    1. 청개구리 사전 초기화 기능
    2. 청개구리 문자열 변환 기능
     */
    public static String solution(String word) {
        FrogDictionary frogDictionary = new FrogDictionary();

        return frogDictionary.convertToFrogString(word);
    }
}
