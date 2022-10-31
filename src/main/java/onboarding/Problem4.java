package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        return transformWord(word);
    }

    public static String transformWord(String word){
        StringBuilder answer = new StringBuilder();
        Map<Character, Character> map = makeMap();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(((int)ch >= 65 && (int)ch <= 90) || ((int)ch >= 97 && (int)ch <= 122)){
                answer.append(map.get(ch));
            }else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    public static Map<Character,Character> makeMap(){
        Map<Character,Character> hashMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            hashMap.put((char) (i+(int)'A'), (char)((25 - i)+(int)'A'));
        }

        for (int i = 0; i < 26; i++) {
            hashMap.put((char) (i+(int)'a'), (char)((25 - i)+(int)'a'));
        }

        return hashMap;
    }
}
