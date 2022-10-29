package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(checkLengthException(word)){
            return null;
        }
        HashMap<Character, Character> alphabetMap = createAlphabetMap();
        answer = changeText(word, alphabetMap);
        return answer;
    }


    // word 길이 1이상 1000 이하 검증
    private static boolean checkLengthException(String word){
        if(word.length() >= 1 && word.length() <= 1000){
            return false;
        }
        return true;
    }

    protected static HashMap<Character,Character> createAlphabetMap(){
        HashMap<Character, Character> result = new HashMap<>();
        List<Character> alphaList = new ArrayList<>();
        List<Character> reverseAlphaList = new ArrayList<>();
        result.put(' ', ' ');
        final int ASCII_A = 65;
        final int ASCII_Z = 90;
        final int ASCII_a = 97;
        final int ASCII_z = 122;
        final int ALPHABET_NUM = 26;

        for(char c=ASCII_A; c <= ASCII_Z; c++){
            alphaList.add(c);
        }
        for(char c=ASCII_Z; c >= ASCII_A; c--){
            reverseAlphaList.add(c);
        }
        for(char c=ASCII_a; c <= ASCII_z; c++){
            alphaList.add(c);
        }
        for(char c=ASCII_z; c >= ASCII_a; c--){
            reverseAlphaList.add(c);
        }
        for(int i=0; i<(ALPHABET_NUM*2);i++){
            result.put(alphaList.get(i), reverseAlphaList.get(i));
        }
        return result;
    }

    protected static String changeText(String text, HashMap<Character, Character> alphabetMap){
        List<Character> charList = seperateText(text);
        Character c, changedChar;
        String result = "";
        for(int i = 0;i < charList.size(); i++){
            c = charList.get(i);
            changedChar = alphabetMap.get(c);
            result += String.valueOf(changedChar);
        }
        return result;
    }

    protected static List<Character> seperateText(String text){
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            charList.add(text.charAt(i));
        }
        return charList;
    }
}
