package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *
 * Class : Problem 4
 *
 * Date : 2022.10.30
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. word를 입력받는다.
 * 2. 청개구리 사전을 만든다.
 * 3. word를 청개구리 사전에 대입하여 변환한다.
 * 4. word는 길이가 1 이상 1,000 이하인 문자열이다.
 * 5. 알파벳 외의 문자는 변환하지 않는다.
 * 6. 알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
 *
 * */


public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // split the sting
        String[] beforeWord = word.split("");
        ArrayList<String> beforeList = new ArrayList<>(Arrays.asList(beforeWord));
        System.out.println(beforeList);

        return answer;
    }
}
