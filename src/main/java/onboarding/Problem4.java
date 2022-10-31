package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 변환된 문자열 만들기
        answer = changeCharacter(word);

        return answer;
    }

    /**
     * 청개구리 사전 기준으로 변환된 문자열을 반환하는 메소드
     * @param str
     * @return 변환된 문자열을 반환
     */
    static String changeCharacter(String str){
        String result = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                result += changeUpperChar(c);
            } else if(Character.isLowerCase(c)){
                result += changeLowerChar(c);
            } else {
                result += c;
            }
        }

        return result;
    }

    /**
     * 대문자: 청개구리 사전 기준으로 문자 변환하는 메소드
     * @param c
     * @return 변환된 문자를 반환
     */
    static char changeUpperChar(char c){
        int asci = (int)c;
        int changeNum = 155 - asci;
        char result = (char) changeNum;

        return result;
    }

    /**
     * 소문자: 청개구리 사전 기준으로 문자 변환하는 메소드
     * @param c
     * @return
     */
    static char changeLowerChar(char c){
        int asci = (int)c;
        int changeNum = 219 - asci;
        char result = (char) changeNum;

        return result;
    }
}
