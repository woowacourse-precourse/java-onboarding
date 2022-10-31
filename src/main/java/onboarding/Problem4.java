package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    /*
        기능목록 :
        1. 대문자를 저장할 upperList 초기화
        2. 소문자를 저장할 lowerList 초기화
        3. 결과를 담을 StringBuilder 초기화
        4. 매개변수 word를 순회하며 대문자 - 65, 소문자 - 65 인덱스를 구한다.
        5. 각각의 인덱스에 접근하여 StringBulder에 append한다.
     */
    public static String solution(String word) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        List<String> upperList = new ArrayList<>(Arrays.asList("Z", "Y", "X", "W", "V", "U",
                                                                "T", "S", "R", "Q", "P", "O",
                                                                "N", "M", "L", "K", "J", "I",
                                                                "H", "G", "F", "E", "D", "C",
                                                                "B", "A"));

        List<String> lowerList = new ArrayList<>(Arrays.asList("z", "y", "x", "w", "v", "u",
                                                                "t", "s", "r", "q", "p", "o",
                                                                "n", "m", "l", "k", "j", "i",
                                                                "h", "g", "f", "e", "d", "c",
                                                                "b", "a"));

        for(int i : word.toCharArray()) {
            if(i == 32) {
                sb.append(" ");
            }
            else if(i >= 65 && i <= 90) {
                sb.append(upperList.get(i - 65));
            }
            else if(i >= 97 && i <= 122) {
                sb.append(lowerList.get(i - 97));
            }
        }

        answer = sb.toString();

        return answer;
    }
}