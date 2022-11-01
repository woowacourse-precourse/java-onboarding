package onboarding.problem2;

public class StringZipper {

    public static String zipString(String cryptogram) {
        while (cryptogram.length() != zipStringOneTime(cryptogram).length()) {
            cryptogram = zipStringOneTime(cryptogram);
        }
        return cryptogram;
    }

    public static String zipStringOneTime(String cryptogram) {
        StringBuilder zippedString = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!checkContinuity(cryptogram, i)) {
                zippedString.append(cryptogram.charAt(i));
            }
        }
        return zippedString.toString();
    }

    public static boolean checkContinuity(String string, int index) {
        if (index != 0 && string.charAt(index - 1) == string.charAt(index)) {
            return true;
        }

        if (index != string.length() - 1 && string.charAt(index + 1) == string.charAt(index)) {
            return true;
        }

        return false;
    }
}