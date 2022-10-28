package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * cryptogram 으로 암호화된 문자열을 해독하는 메소드
     * @param cryptogram : 해독할 문자열
     * @return 해독된 문자열
     */
    private static String decodeCryptogram(String cryptogram){
        // 해독 결과 변수
        String result = cryptogram;
        // result의 값을 저장하기 위한 변수
        String tempResult = null;

        // 중복 제거 후 변화가 없을 때까지 중복 제거
        while (!result.equals(tempResult)){
            tempResult = result;
            result = removeDuplication(result);
        }

        // 모든 중복이 제거된 (해독된) 결과 반환
        return result;
    }

    /**
     * 문자열의 중복 문자열을 찾아 제거하는 메소드
     * @param str : 중복 문자열을 삭제할 메소드
     * @return 중복 문자열이 제거된 문자열
     */
    private static String removeDuplication(String str){

    }
}
