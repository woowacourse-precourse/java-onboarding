package onboarding;

public class Problem2 {
    
    static char lastRemoved;

    public static void main(String[] args) {
        String crypto = "browoanoommnaon";

        System.out.println("answer = " + solution(crypto));
    }

    public static String solution(String cryptogram) {
        if (cryptogram.length() == 0 || cryptogram.length() == 1)
            return cryptogram;

        if (cryptogram.charAt(0) == cryptogram.charAt(1)) {
            lastRemoved = cryptogram.charAt(0);
            while (cryptogram.length() > 1
              && cryptogram.charAt(0) == cryptogram.charAt(1))
                cryptogram = cryptogram.substring(1, cryptogram.length());
            cryptogram = cryptogram.substring(1, cryptogram.length());
            return solution(cryptogram);
        }

        String remStr = solution(cryptogram.substring(1, cryptogram.length()));

        if (remStr.length() != 0
          && remStr.charAt(0) == cryptogram.charAt(0)) {
            lastRemoved = cryptogram.charAt(0);

            return remStr.substring(1, remStr.length());
        }

        if (remStr.length() == 0
          && lastRemoved == cryptogram.charAt(0))
            return remStr;

        return (cryptogram.charAt(0) + remStr);
    }

    static String remove(String str) {
        lastRemoved = '\0';
        return solution(str);
    }
}
