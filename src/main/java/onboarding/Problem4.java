package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
//        String answer = "";
        Map<Character, Character> dict = new HashMap<>();

        char curr = 'Z';
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            dict.put(ch, curr);
            dict.put((char)(ch - 'A' + 'a'), (char)(curr - 'A' + 'a'));
            curr--;
        }

        StringBuilder temp = new StringBuilder();
        for(char ch : word.toCharArray()) {
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                temp.append(dict.get(ch));
            }
            else{
                temp.append(ch);
            }
        }

        return temp.toString();
    }
}
