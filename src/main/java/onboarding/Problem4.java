package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder builder = new StringBuilder();
        Map<String, String> AlphabetMap = convertAlphabet();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);

            if((w >= 48 && w <= 57)||(w >= 65 && w <= 122)){    //알파벳인 경우
                builder.append(AlphabetMap.get(String.valueOf(w)));
            } else {
                builder.append(w);
            }
        }
        return builder.toString();
    }

    public static Map<String, String> convertAlphabet(){
        Map<String, String> alphabetMap = new HashMap<>();

        for(int i=0; i<26; i++){
            alphabetMap.put(String.valueOf((char)(65+i)), String.valueOf((char)(90-i)));
            alphabetMap.put(String.valueOf((char)(97+i)), String.valueOf((char)(122-i)));
        }

        return alphabetMap;
    }
}
