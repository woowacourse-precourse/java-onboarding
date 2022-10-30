package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decoding(cryptogram);
        return answer;
    }

    public static String decoding(String text) {
        char[] charArray = text.toCharArray();
        // 결과를 담을 변수 선언
        String result = "";

        // 메소드를 다시 실행할 조건 변수 선언
        int i, k = 0;
        // outofbound 에러 처리, 동일한 값이 있을경우 i 값 증가
        for (i = 0; i < charArray.length; i++) {
            if (i != charArray.length - 1 && charArray[i] == charArray[i + 1]) {
                i++;
            }
        // 동일한 값이 없을 경우 값을 result에 그대로 담고 k 값 증가
            else {
                result += charArray[i];
                k++;
            }
        }
        // i와 k의 값이 다른 경우 (중복제거가 한번이라도 일어난 경우) 함수를 재실행
        if (i != k) {
            return decoding(result);
        } else {
            return result;
        }
    }
}
