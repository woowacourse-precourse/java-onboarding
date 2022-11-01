package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        int len = cryptogram.length();
        // 정규표현식으로 연속된 문자 제거
        answer = cryptogram.replaceAll("(.)\\1+", "");
        return answer;
    }
}
