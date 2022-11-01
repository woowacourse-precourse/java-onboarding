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
        HashMap<Character, Character> alphabetMap = createAlphabetMap();
        answer = getFrogText(word, alphabetMap);
        return answer;
    }

    // [Key:알파벳, Value:청개구리 알파벳]을 가진 HashMap 생성
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
    
    // a ~ Z 알파벳 리스트 생성
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

    // z ~ A 알파벳 리스트 생성
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
    
    // 청개구리식으로 텍스트 변환
    protected static String getFrogText(String text, HashMap<Character, Character> alphabetMap){
        List<Character> charList = seperateText(text);
        Character changedChar;
        String result = "";
        for(Character c : charList){
            changedChar = alphabetMap.get(c);
            result += String.valueOf(changedChar);
        }
        return result;
    }
    
    // 텍스트를 문자 배열로 분리
    protected static List<Character> seperateText(String text){
        List<Character> charList = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            charList.add(text.charAt(i));
        }
        return charList;
    }
}
