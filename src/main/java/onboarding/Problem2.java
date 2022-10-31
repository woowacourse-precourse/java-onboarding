package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            String[] split = cryptogram.split("(([a-zA-Z0-9])\\2{1,})");
            if (split.length > 1) {
                cryptogram = String.join("", split);
            } else if (split.length == 0) {
                cryptogram = "";
            }
            else break;
        }

        return cryptogram;
    }
}
