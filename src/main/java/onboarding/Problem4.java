package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem4 {
    public static String charConverter(char word) {
        // 대문자 아스키 코드 범위
        boolean upperCase = (int)word >= (int)'A' && (int)word <= (int)'Z';
        int upperCaseSum = (int)'A' + (int)'Z';

        // 소문자 아스키 코드 범위
        boolean lowerCase = (int)word >= (int)'a' && (int)word <= 'z';
        int lowerCaseSum = (int)'a' + (int)'z';

        char convertedWord = word;    // 알파벳이 아닌 경우를 위해서 word로 초기화
        if(upperCase) {    // 대문자인 경우
            convertedWord = (char)(upperCaseSum - (int)word);
        }
        if(lowerCase) {    // 소문자인 경우
            convertedWord = (char)(lowerCaseSum - (int)word);
        }

        return String.valueOf(convertedWord);    // 최종 반환은 문자열로 바꿔서 반환
    }

    public static String solution(String word) {
        String answer = "";

        List<String> wordList = new ArrayList<>(Arrays.asList(word.split("")));

        for(String str : wordList) {
            answer += charConverter(str.charAt(0));    // 문자열을 char 타입으로 바꿔서 charConverter()에 인자로 넣기
        }

        return answer;
    }
}
