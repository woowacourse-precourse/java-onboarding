package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static HashMap<Character,Character> dictionary;
    public static void setDictionary() {
        int currentUpperValue = 'Z';
        for(int ascii = 'A'; ascii <= 'Z'; ascii++) {
            dictionary.put((char) ascii, (char) currentUpperValue);
            currentUpperValue--;
        }

        int currentLowerValue = 'z';
        for(int ascii = 'a'; ascii <= 'z'; ascii++){
            dictionary.put((char)ascii,(char)currentLowerValue);
            currentLowerValue--;
        }
    }
    public static String changeFrogWord(String word) {
        String answer = "";
        char[] chars = word.toCharArray();
        for(int index=0; index < chars.length; index++) {
            if(dictionary.containsKey(chars[index]) == true){
                answer = answer + dictionary.get(chars[index]);
            }
            if(dictionary.containsKey(chars[index]) == false){
                answer = answer + chars[index];
            }
        }
        return answer;
    }
    public static String solution(String word) {
        dictionary = new HashMap<>();
        setDictionary();

        String answer = changeFrogWord(word);
        return answer;
    }
}
