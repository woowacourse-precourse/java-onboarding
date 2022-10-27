package onboarding;

/*
 * # 기능 정리
 * [O] 연속하는 중복문자 검증
 * [O] 제거된 문자열 반환 메서드
 * [X] 1~2 기능 반복 메서드
 * [X] solution 작성
 * [X] 테스트 확인
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        return answer;
    }

    private static StringBuffer compressString(final String str){
        StringBuffer compressedString = new StringBuffer();

        compressedString.append(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
            char beforeChar = str.charAt(i - 1);
            char currentChar = str.charAt(i);

            if(beforeChar != currentChar)
                compressedString.append(currentChar);
        }

        return compressedString;
    }
}
