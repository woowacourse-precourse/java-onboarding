package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) throws Exception {
        String answer = "answer";
        answer = decode(cryptogram);
        return answer;
    }

    private static String decode(String cryptogram) throws Exception {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new Exception("입력값의 길이가 올바르지 않습니다");
        }
        return "아직 처리x";
    }
}
