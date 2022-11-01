package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        int len = cryptogram.length();
        // 정규표현식으로 연속된 문자 제거
        answer = cryptogram.replaceAll("(.)\\1+", "");

        // 최악을 가정하고 최소 횟수는 절반까지
        for (int i = 0; i < len/2; i++)  {
            answer = answer.replaceAll("(.)\\1+", "");
        }
        return answer;
    }
}
