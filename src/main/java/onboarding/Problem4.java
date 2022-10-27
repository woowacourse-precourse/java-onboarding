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
            result += changeChar(c);
        }

        return result;
    }

    /**
     * 청개구리 사전 기준으로 문자 변환하는 메소드
     * @param c
     * @return 변환된 문자를 반환
     */
    static char changeChar(char c){
        int asci = (int)c;
        int changeNum = 155 - asci;
        char result = (char) changeNum;

        return result;
    }
}
