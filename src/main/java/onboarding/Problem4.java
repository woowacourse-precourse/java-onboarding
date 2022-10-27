package onboarding;

import onboarding.problem4.NotWantedCharacter;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 1. 배열에 청개구리 사전 저장
        ArrayList<Character> upperDictionary = new ArrayList<>();
        ArrayList<Character> lowerDictionary = new ArrayList<>();


        for (int i = 0; i < 26; i++) {
            upperDictionary.add((char) ('Z'-i));
            lowerDictionary.add((char) ('z' - i));
        }




        return answer;
    }
}
