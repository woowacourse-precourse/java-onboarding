package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        HashMap<Integer,Integer> dictionary = getDictionary();
        int length = word.length();
        StringBuffer sbWord = new StringBuffer(word);
        for(int i=0;i<length;i++){
            if(sbWord.charAt(i)==' ') continue;
            char preChar = sbWord.charAt(i);
            char postChar = changeCharacter(preChar,dictionary);
            sbWord.replace(i,i+1, String.valueOf(postChar));
        }

        return sbWord.toString();
    }

    //청개구리 사전을 만드는 함수
    public static HashMap<Integer,Integer> getDictionary(){
        HashMap<Integer,Integer> dictionary = new HashMap<>();
        //소문자
        for(int i=97;i<123;i++){
            dictionary.put(i,219-i);
        }
        //대문자
        for(int i=65;i<91;i++){
            dictionary.put(i,155-i);
        }

        return dictionary;
    }

    //값 변환해주는 함수
    public static char changeCharacter(char c, HashMap<Integer,Integer> dictionary){
        int charToInt = c;
        int ascii = dictionary.get(charToInt);
        char intToChar = (char) ascii;

        return intToChar;
    }


}
