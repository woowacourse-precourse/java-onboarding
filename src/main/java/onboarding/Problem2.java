package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String cryptogramOrigin;
        int idx;
        while(true) {
            cryptogramOrigin = cryptogram;
            for (int i = 0; i < cryptogram.length(); i++) {
                idx = i + 1;
                while (idx < cryptogram.length() && cryptogram.charAt(idx) == cryptogram.charAt(i)) {
                    idx++;
                }
                if (idx - i > 1)
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(idx);
            }

            if (cryptogramOrigin.equals(cryptogram))
                return cryptogram;
        }
    }
}
