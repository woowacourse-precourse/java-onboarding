package onboarding;

import java.util.HashMap;

public class Problem4 {

    //대문자, 소문자 배열생성
    static char[] upperCase = new char[26];
    static char[] lowerCase = new char[26];
    static void createStringArray(){
        for(int i=0; i<upperCase.length; i++){
            upperCase[i] = (char)(i+'A');
            lowerCase[i] = (char)(i+'a');
        }
        return;
    }

    //맵으로 각각의 알파벳 마다 매칭되는 값 저장하기
    static HashMap<Character, Character> map = new HashMap<>();
    static void setMap(){
        for(int i=0; i<upperCase.length; i++){
            map.put(upperCase[i],upperCase[25-i]);
            map.put(lowerCase[i],lowerCase[25-i]);
        }
        return;
    }
    public static String solution(String word) {
        String answer = "";

        //문자 하나씩 치환하고, 알파벳이 아니라면 추가하지 않기
        createStringArray();
        setMap();
        for(int i=0; i<word.length(); i++){

            char temp = map.getOrDefault(((char)(word.charAt(i))),((char)(word.charAt(i))));

            answer += temp;
        }

        return answer;
    }
}
