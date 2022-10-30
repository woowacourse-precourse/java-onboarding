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
            int alphDictIdx = 0;
            if(Character.isAlphabetic(alphabet)){ //알파벳이면 변환
                if(Character.isLowerCase(alphabet)){ //소문자일 경우
                    char tmpConvertToUpp = Character.toUpperCase(alphabet);
                    alphDictIdx = alpDict.indexOf(tmpConvertToUpp);
                    answer += Character.toLowerCase(alpDict.get(25 - alphDictIdx));
                }
                else{
                    alphDictIdx = alpDict.indexOf(alphabet);
                    answer += alpDict.get(25-alphDictIdx);
                }
            }
            else answer += alphabet;
        }

        return answer;
    }
}
