package onboarding;

public class Problem2 {
    static boolean isReversible(String cryptogram) {
        char[] cryptogramCharArray = cryptogram.toCharArray();
        for (int i = 0; i < cryptogramCharArray.length/2; i++) {
            if (cryptogramCharArray[i] != cryptogramCharArray[cryptogramCharArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    static String getRemovedDuplicateString(String cryptogram) {
        return cryptogram.replaceAll("([a-z])\\1{1,}","");
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            // 문자열의 길이가 0일 경우 바로 종료
            if (answer.length() == 0) {
                return answer;
            }
            // 문자열이 대칭일 경우 빈 문자열 반환
            if (isReversible(answer)) {
                return "";
            }
            // 전 문자열을 저장
            String prev_answer = answer;
            // 중복 제거
            answer = getRemovedDuplicateString(answer);
            // 전 문자열과 중복 제거한 문자열이 같을 경우 문자열 반환 후 종료
            if(answer == prev_answer) {
                return answer;
            }
        }
    }
}
