package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {

        List<Character> result = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);

            getGreenFrogString(result, ascii);
        }

        //result 스택에서 String 값으로 변환
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : result) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }

    /**
     *  ascii code 값을 인자로 받고 대문자는 대문자끼리, 소문자는 소문자끼리, SPACE일때는 그대로 result 리스트에 추가하는 메서드
     */
    private static void getGreenFrogString(List<Character> result, int ascii) {
        //아스키 코드가 SPACE일때
        if(ascii == 32) {
            result.add(' ');
            return;
        }
        
        //아스키 코드가 대문자일때
        if(ascii <= 90) {
            ascii = 155 - ascii;
            result.add((char) ascii);
            return;
        }

        //아스키 코드가 소문자일때
        ascii = 219 - ascii;
        result.add((char) ascii);
    }


}
