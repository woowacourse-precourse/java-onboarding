package onboarding;
import java.lang.String;
public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }

    public static boolean checkDouble(String cryptogram) {
        for (int i = 0; i < cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }



}
