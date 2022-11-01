package onboarding;

public class Problem2 {
    public static boolean isDuplicate(String cryptogram) {
        char prev = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if(prev == cryptogram.charAt(i)) {
                return true;
            }
            prev = cryptogram.charAt(i);
        }
        return false;
    }



    public static String solution(String cryptogram) {
        String answer = "";
        return answer;
    }
}
