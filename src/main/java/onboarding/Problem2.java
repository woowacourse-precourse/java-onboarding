package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        /*
        1. 기능 목록 1~4를 cryptogram 길이가 짧아지고 1보다 클 동안 반복
         */

        /*
        2. 필요한 변수 셋팅
        - preCharacter: i - 1번째 문자
        - nowCharacter: i번째 문자
        - count: 연속된 문자 수
        - cryptogramLength: 문자열 cryptogram의 길이
         */

        /*
        3. cryptogram에서 i번째 문자 추출
         */

        /*
        4. nowCharacter가 preCharacter와 같지 않은 경우
        - count == 1 이라면: 임시 문자열 tmp에 preCharacter와 추가
        - i가 cryptogramLength - 1이라면: 임시 문자열 tmp에 nowCharacter 추가
        - preCharacter를 nowCharacter로 치환 후 count를 1로 초기화
         */

        /*
        5. nowCharacter가 preCharacter와 같은 경우
        - count를 1 증가
         */

        return answer;
    }
}
