package onboarding;

public class Problem4 {
    // 기능 구현 목록
    // 1. 예외처리 (word의 길이가 1 이상 10,000이하가 아닌 경우)
    // 2. 청개구리 사전에따라 입력된 문자열을 변환
    public static String solution(String word) {
        String result = "";

        // 예외처리
        // 1. word의 길이가 1 이상 10,000이하가 아니라면
        if (!(1 <= word.length()) && (10000 >= word.length())){
            result = "exceed the range";
            return result;
        }


        return answer;
    }
}
