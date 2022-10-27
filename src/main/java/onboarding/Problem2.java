package onboarding;

/**
 * 기능 구현 사항
 * 1. 연속된 문자열 삭제 함수
 */
public class Problem2 {
    private static String deleteChar(String cryptogram){
        String result = "";
        for (int i = 0; i < cryptogram.length(); i++){
            if ((i != 0) && (cryptogram.charAt(i) == cryptogram.charAt(i-1))) {
                continue;
            }
            result += cryptogram.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        answer = deleteChar(cryptogram);
        return answer;
    }
}
