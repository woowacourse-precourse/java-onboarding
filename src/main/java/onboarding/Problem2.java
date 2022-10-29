package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    private static List<Character> StringToChars(String text){
        List<Character> seperatedCryptogram = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            seperatedCryptogram.add(text.charAt(i));
        }
        return seperatedCryptogram;
    }
}
