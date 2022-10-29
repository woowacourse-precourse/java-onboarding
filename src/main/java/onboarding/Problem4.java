package onboarding;

import java.util.HashMap;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    //청개구리 사전을 만드는 함수
    public static HashMap<Integer,Integer> getDictionary(){
        HashMap<Integer,Integer> dictionary = new HashMap<>();
        //소문자
        for(int i=97;i<110;i++){
            dictionary.put(i,219-i);
        }
        //대문자
        for(int i=65;i<78;i++){
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
