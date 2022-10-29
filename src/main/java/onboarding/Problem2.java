package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        // 1. 입력된 문자를 decode 메소드로 해석
        // 2. 해석된 결과 값 반환
        String answer = decode(cryptogram);
        return answer;
    }
    static String decode(String cryptogram) {
        // 1. decode 탈출 조건 설정
        // 1-1. 연속된 중복 문자가 없는 경우 : 탈출, 결과 값 반환
        // 1-2. 연속된 중복 문자가 있는 경우 : 탈출 할 때 까지 반복
        // 2. 연속된 문자를 찾음
        // 3. 입력된 문자열에서 연속된 문자 제거
        // 4. 3번 결과 값을 decode에 다시 입력
    }
}
