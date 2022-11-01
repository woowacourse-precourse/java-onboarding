package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {

        Map<String,String> alphabet = new HashMap<>(27);

        return wordReverser(word,alphabetMap(alphabet));
    }//public static String solution

    public static Map<String,String> alphabetMap(Map<String,String> alphabet){
        char rc = 'z';
        char rC = 'Z';

        for(char c = 'a'; c <= 'z'; c++) {
            alphabet.put(String.valueOf(c),String.valueOf(rc));
            rc--;
        }
        for(char c = 'A'; c <= 'Z'; c++) {
            alphabet.put(String.valueOf(c),String.valueOf(rC));
            rC--;
        }

        return alphabet;
    }//public static Map<String,String> getMap

    public static String wordReverser(String word,Map<String,String> alphabet){
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < word.length(); i++) {
            if(word.substring(i, i+1).matches("^[a-zA-Z]*$")) {
                result.append(alphabet.get(word.substring(i, i + 1)));
                continue;
            }
            result.append(word.charAt(i));
        }

        return result.toString();
    }//public static String wordReverser

}//public class Problem4
