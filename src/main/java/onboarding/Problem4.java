package onboarding;

import java.util.HashMap;

//## PROBLEM4 기능 구현 정리
//        1. 예외처리 :
//          초반 예외 :word 길이 1이상 1000 이하 검증
//          3번 기능 예외 : 알파벳이 아니면 문자 반환 X
//        2. 알파벳 HashMap 생성
//          - 'a'~'z'='z'~'a'
//          - 'A'~'Z'='Z'~'A'
//          - ' ' -> ' '반환
//        3. 문자열 분리
//        4. 분리된 문자들 HashMap에 Key로 넣어서 Value반환받기
//          - 하나씩 반한받아서 String 변수에 +로 붙이기
//        5. 결과 출력
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(checkLengthException(word)){
            return null;
        }
        return answer;
    }


    // word 길이 1이상 1000 이하 검증
    private static boolean checkLengthException(String word){
        if(word.length() >= 1 && word.length() <= 1000){
            return false;
        }
        return true;
    }
}
