package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] wordArray = word.toCharArray();
        Map<Character, Character> dictionary = makeDictionary();

        answer = encodeWord(wordArray, dictionary);


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

    public static String encodeWord(char[] wordArray, Map<Character, Character> dictionary){
        char[] encodedArray = new char[wordArray.length];
        int ascii_index = 0;

        for(int i=0;i<wordArray.length;i++){
            if(checkAlphabet(wordArray[i])!=1){
                encodedArray[i] = wordArray[i];
                continue;
            }
            encodedArray[i] = dictionary.get((Character)wordArray[i]);
        }

        String encoded = String.valueOf(encodedArray);
        return encoded;
    }

    public static int checkAlphabet(char character){
        if((64<character&&character<91)||(96<character&&character<123)) return 1;
        return -1;
    }


}
