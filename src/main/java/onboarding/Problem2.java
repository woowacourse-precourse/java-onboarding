package onboarding;

/*
 *  🚀 기능 명세
    주어진 문자열에 대해 반복해서 압축을 실행할 메서드 (deleteContinuousChar)
    주어진 문자열이 더이상 압축되지 않을때까지 압축을 수행할 메서드 (solution)
    *
 */

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while(true){
            String cryptogramAfterDelete = deleteContinuousChar(answer);
            if(cryptogramAfterDelete.equals(answer)) break;
            answer = cryptogramAfterDelete;
        }
        return answer;
    }

    static String deleteContinuousChar(String cryptogram){
        String cryptogramAfterDelete = "";

        for(int i = 0 ; i < cryptogram.length() ; i++){
            if(i != 0 && cryptogram.charAt(i - 1) == cryptogram.charAt(i)) continue;
            if(i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) continue;
            cryptogramAfterDelete += cryptogram.charAt(i);
        }
        return cryptogramAfterDelete;
    }
}
