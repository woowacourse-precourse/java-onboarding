package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // 입력받은 문자열을 어절 단위로 자름
        String[] chunk = word.split(" ");
        // 변환하기
        for(int i=0; i<chunk.length; i++){
            String str = chunk[i];
            answer += changeChunk(str);
            answer += " ";
        }

        // 변환된 문자열 만들기

        return answer.substring(0, answer.length()-1);
    }

    /**
     * 청개구리 사전 기준으로 변환된 문자열을 반환하는 메소드
     * @param chunk
     * @return 변환된 문자열을 반환
     */
    static String changeChunk(String chunk){
        String result = "";

        for(int i=0; i<chunk.length(); i++){
            char c = chunk.charAt(i);
            if(Character.isUpperCase(c)){
                result += changeUpperChar(c);
            } else if(Character.isLowerCase(c)){
                result += changeLowerChar(c);
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
