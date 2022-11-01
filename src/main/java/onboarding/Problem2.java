package onboarding;

public class Problem2 {
    // 기능 구현 목록
    // 1. 예외처리 (cryptogram의 길이가 1이상 1000 이하인 문자열이 아닌 경우)
    // 2. 문자열 해독 및 해독한 문자열 반환
    public static String solution(String cryptogram) {

        //예외처리
        // 1. cryptogram의 길이가 1이상 1000 이하인 문자열이 아닌 경우
        if (1 > cryptogram.length() || 1000 < cryptogram.length()){
            String e = "wrong input";
            return e;
        }
        return answer;
    }
}
