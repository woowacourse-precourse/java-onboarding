package onboarding;

import java.util.HashMap;

/*
기능 목록
1. 알파벳외 문자 확인
2. 대문자 to 대문자, 소문자 to 소문자
3. 문자열의 길이 1 ~ 1000
 */
public class Problem4 {
    public static boolean isAlpah(char c){
        return Character.isAlphabetic(c);
    }
    public static HashMap<Character,Character> initWord(){
        HashMap<Character,Character> alpah = new HashMap<Character,Character>();
        int i = 97;
        for(int c = 122; c>=97;c--){
            alpah.put((char)c,(char)(i));
            i++;
        }
        return alpah;
    }

    public static String solution(String word) {
        String answer = "";
        StringBuilder tmp = new StringBuilder();

        HashMap<Character,Character> alpah = initWord();

        for(char c:word.toCharArray()){
            if(isAlpah(c)) {
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                    c = alpah.get(c);
                    c = Character.toUpperCase(c);
                } else {
                    c = alpah.get(c);
                }
            }

            tmp.append(c);
        }

        answer = tmp.toString();
        return answer;
    }
}