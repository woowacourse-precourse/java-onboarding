package onboarding;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {
    
    // 대문자, 소문자에 따라 나누어 청개구리 사전으로 변환해주는 메소드
    public static Character conversion(Character c){
        int temp = 0;
        // 대문자일 때 변환
        if (isUpperCase(c)){
            temp = (int)'Z' - ((int)c -(int)'A');
        } 
        // 소문자일 때 변환
        else if (isLowerCase(c)) {
            temp = (int)'z' - ((int)c -(int)'a');
        }
        return (char)temp;
    }
    public static String solution(String word) {
        String answer = "";

        for (int i =0; i < word.length(); i++) {
            char c = word.charAt(i); // 단위 문자로 쪼갬
            // 만약 문자 c가 알파벳이 아니라면(ex space) 그대로 추가
            if(!Character.isAlphabetic(c)){
                answer += c;
                continue;
            }
            // 알파벳이라면 문자별 conversion 실행 후 추가
            answer += conversion(c);

        }
        return answer;
    }
}

// 체크사항
// 1. 아스키코드 사용 25차이
// 2. String to Char
// 3. 예외처리 isAlphabetic