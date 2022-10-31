package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem4 {
    private final static int ALPHABET_NUM = 26;
    private final static int ASCII_A = 65;
    private final static int ASCII_Z = 90;
    private final static int ASCII_a = 97;
    private final static int ASCII_z = 122;

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
        HashMap<Character, Character> alphabetMap = new HashMap<>();
        List<Character> alphaList = makeAlphaList();
        List<Character> reverseAlphaList = makeReverseAlphaList();
        alphabetMap.put(' ', ' ');

        for(int i=0; i<(ALPHABET_NUM*2);i++){
            alphabetMap.put(alphaList.get(i), reverseAlphaList.get(i));
        }
        return alphabetMap;
    }

    private static List<Character> makeAlphaList() {
        List<Character> alphaList = new ArrayList<>();
        for(char c=ASCII_a; c <= ASCII_z; c++){
            alphaList.add(c);
        }
        for(char c=ASCII_A; c <= ASCII_Z; c++){
            alphaList.add(c);
        }
        return alphaList;
    }

    private static List<Character> makeReverseAlphaList() {
        List<Character> reverseAlphaList = new ArrayList<>();
        for(char c=ASCII_z; c >= ASCII_a; c--){
            reverseAlphaList.add(c);
        }
        for(char c=ASCII_Z; c >= ASCII_A; c--){
            reverseAlphaList.add(c);
        }
        return reverseAlphaList;
    }

    protected static String changeText(String text, HashMap<Character, Character> alphabetMap){
        List<Character> charList = seperateText(text);
        Character changedChar;
        String result = "";
        for(Character c : charList){
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
