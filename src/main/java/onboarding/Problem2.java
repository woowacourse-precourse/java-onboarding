package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int cryptogramLength;

        /*
        1. 기능 목록 1~4를 cryptogram 길이가 짧아지고 1보다 클 동안 반복
         */
        do {
            /*
            2. 필요한 변수 셋팅
            - preCharacter: i - 1번째 문자
            - nowCharacter: i번째 문자
            - count: 연속된 문자 수
            - cryptogramLength: 문자열 cryptogram의 길이
             */
            char preCharacter = cryptogram.charAt(0);
            char nowCharacter;
            String tmp = "";
            int count = 1;

            cryptogramLength = cryptogram.length();
            for(int i = 1; i < cryptogramLength; i++) {
                /*
                3. cryptogram에서 i번째 문자 추출
                 */
                nowCharacter = cryptogram.charAt(i);
            }

        } while (cryptogramLength > cryptogram.length() && cryptogram.length() > 1);



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
