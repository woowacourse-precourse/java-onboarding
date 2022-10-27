package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    //문자열 길이가 2 이상인지 체크하는 함수
    public static boolean isLengthLong(String cryptogram) {
        int length = cryptogram.length();
        if (length < 2) return false;
        return true;
    }
}
