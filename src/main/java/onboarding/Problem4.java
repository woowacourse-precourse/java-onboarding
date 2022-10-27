package onboarding;

import java.util.HashMap;
import java.util.Map;

/**
 * 기능 요구사항
 * 1. 청개구리 사전을 구현한다.
 * 2. 주어진 word를 반대로 변환해야 한다.
 */
public class Problem4 {
    static Map<Character, Character> frogDictionary;
    public static String solution(String word) {
        String answer = "";
        frogDictionary = new HashMap<>();
        makingDictionary();
        answer = reverseWord(word);
        return answer;
    }

    private static String reverseWord(String word) {
        StringBuilder reverse = new StringBuilder();
        for(char c : word.toCharArray()){
            if(Character.isAlphabetic(c)){
                if(c>=97&&c<=122){
                    reverse.append((char) (frogDictionary.get((char)(c - 32)) + 32));
                }else{
                    reverse.append(frogDictionary.get(c));
                }
            }else{
                reverse.append(c);
            }
        }
        return reverse.toString();
    }

    private static void makingDictionary() {
        int tmp = 90;
        for(int i=65;i<=90;i++){
            frogDictionary.put((char) i, (char) tmp--);
        }
    }
}
