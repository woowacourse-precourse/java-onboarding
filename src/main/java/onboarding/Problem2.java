package onboarding;
import onboarding.problem2.Compress;

public class Problem2 {
    public static String solution(String cryptogram) {
        String result = Compress.compressWord(cryptogram);
        return result;
    }
}