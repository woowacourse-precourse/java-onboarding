package onboarding;

import java.util.ArrayList;
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
 * 4. 알파벳 외의 문자는 변환하지 않고 값을 반환한다.
 * 5. word는 길이가 1 이상 1,000 이하인 문자열이므로 아무것도 들어오지 않으면 아무것도 반환하지 않으며 1,000 초과된 문자열이면 1,000까지만 변환을 해준다.
 *
 * */


public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        if (word.isEmpty()) {
            return answer;
        }
        else if (word.length() > 1000){
            word = word.substring(0,1000);
        }

        // the list of alphabet conversion
        HashMap<Character, Character> upperCase = new HashMap<>();
        HashMap<Character, Character> lowerCase = new HashMap<>();
        for (char key = 'A', value = 'Z'; key <= 'Z'; key++, value--) {
            upperCase.put(key, value);
        }
        for (char key = 'a', value = 'z'; key <= 'z'; key++, value--) {
            lowerCase.put(key, value);
        }

        // // split the string to character
        ArrayList<Character> resultList = new ArrayList<>();
        char[] beforeWord = word.toCharArray();
        for (char before : beforeWord) {
            if (Character.isUpperCase(before)){
                resultList.add(upperCase.get(before));
            }
            else if (Character.isLowerCase(before)){
                resultList.add(lowerCase.get(before));
            }
            else {
                resultList.add(before);
            }
        }

        for (Character item : resultList) {
            answer += item;
        }

        return answer;
    }
}
