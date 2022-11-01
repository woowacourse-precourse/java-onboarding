package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String temp = "";
        boolean isChanged = true;

        while (isChanged) {

            isChanged = false;
            temp = "";

            for (int i = 0; i < cryptogram.length(); i++) {
                if (i == 0) {
                    if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                        temp += cryptogram.charAt(i);
                    } else {
                        isChanged = true;
                    }
                } else if (i == cryptogram.length() - 1) {
                    if (cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                        temp += cryptogram.charAt(i);
                    } else {
                        isChanged = true;
                    }
                } else {
                    if (cryptogram.charAt(i) != cryptogram.charAt(i + 1) && cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                        temp += cryptogram.charAt(i);
                    } else {
                        isChanged = true;
                    }
                }
            }

            cryptogram = temp;
        }

        return cryptogram;
    }
}
