package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static Map<Character, Character> makeDictionary(){
        Map<Character, Character> dictionary = new HashMap<>();
        for(int i =0; i <26 ; i++){
            //a-z 넣기
            int key_ascii = 65+i;
            int val_ascii = 90-i;
            char key = (char)key_ascii;
            char value = (char)val_ascii;
            dictionary.put(key, value);

            //A-Z 넣기
            key_ascii = 97+i;
            val_ascii = 122-i;
            key = (char)key_ascii;
            value = (char)val_ascii;
            dictionary.put(key, value);

        }
        return dictionary;
    }

    public static int checkAlphabet(char character){
        if((64<character&&character<91)||(96<character&&character<123)) return 1;
        return -1;
    }


}
