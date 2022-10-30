package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
 * 2. 청개구리 사전을 대,소문자로 만든다.
 * 3. word를 청개구리 사전에 대입하여 변환한다.
 * 4. word는 길이가 1 이상 1,000 이하인 문자열이다.
 * 5. 알파벳 외의 문자는 변환하지 않는다.
 *
 * */


public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // the list of alphabet conversion
        HashMap<Character, Character> upperCase = new HashMap<>();
        HashMap<Character, Character> lowerCase = new HashMap<>();
        for (char key = 'A', value = 'Z'; key <= 'Z'; key++, value--) {
            upperCase.put(key, value);
        }
        for (char key = 'a', value = 'z'; key <= 'z'; key++, value--) {
            lowerCase.put(key, value);
        }

        // split the sting
        String[] beforeWord = word.split("");
        ArrayList<String> beforeList = new ArrayList<>(Arrays.asList(beforeWord));
        System.out.println(beforeList);

        return answer;
    }
}
