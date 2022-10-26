package onboarding;

public class Problem2 {
    public static String solution(String cryptogram)
    {
        String answer = "answer";
        answer = checkCryptogram(cryptogram);
        return answer;
    }
    public static String checkCryptogram(String cryptogram)
    {
        String crypto = "";
        crypto = cryptogram;
        if (crypto.length() == 1 ) return crypto; // 문자열 길이가 1 이다.


        return crypto;
    }
}
