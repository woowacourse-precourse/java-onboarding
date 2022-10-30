package onboarding.problem2;

public class StringZipper {

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