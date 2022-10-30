package onboarding;

public class Problem2 {
    public static String delSame(String cryptogram, int i) {
        if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)){
            cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
