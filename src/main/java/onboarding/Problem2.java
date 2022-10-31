package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            String temp = "";

            for (int i = 0; i < cryptogram.length(); i++) {
                if (i == cryptogram.length() - 1) temp += cryptogram.charAt(i);
                else {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) i++;
                    else temp += cryptogram.charAt(i);
                }
            }

            if (cryptogram.equals(temp)) return temp;
            else cryptogram = temp;
        }
    }
}
