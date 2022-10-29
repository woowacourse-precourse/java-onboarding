package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        while (true) {
            cryptogram = DelOverlap(cryptogram);
            if (cryptogram.equals(DelOverlap(cryptogram))) break;
        }

        return cryptogram;
    }

    static String DelOverlap(String str) {
        String tmp = "";

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                tmp += str.charAt(i);
                if (i == str.length() - 2) {
                    tmp += str.charAt(i + 1);
                }
            }
            else {
                if (i == str.length() - 3) {
                    tmp += str.charAt(i + 2);
                }
                i++;
            }
        }
        return tmp;
    }


}

