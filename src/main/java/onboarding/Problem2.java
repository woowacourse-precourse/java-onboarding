package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // crytogram와 길이, 값이 일치한 StringBuffer 생성
        StringBuffer sb = getSStringBuffer(cryptogram);

        //

        return answer;
    }

    // String 매개변수와 길이, 값이 일치한 StringBuffer 반환
    private static StringBuffer getSStringBuffer(String cryptogarm) {
        StringBuffer sb = new StringBuffer(cryptogram.length());
        sb.append(cryptogram);
        return sb;
    }
}
