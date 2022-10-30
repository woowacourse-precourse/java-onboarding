package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> alpDict = List.of('A','B','C','D','E','F','G',
                                        'H','I','J','K','L','M','N','O','P','Q',
                                        'R','S','T','U','V','W','X','Y','Z');

        for(int idx = 0; idx < word.length(); idx++){
            char alphabet = word.charAt(idx);
            if(Character.isAlphabetic(alphabet)){ //알파벳이면 변환
                
            }
        }

        return answer;
    }
}
