package onboarding.P4;

public class WordVerification {
    public static boolean LengthCheck(String word) {
        char[] ch = word.toCharArray();
        if (ch.length >= 1 && ch.length <= 1000) {                               //문자 길이
            return true;
        } else {
            return false;
        }
    }
}
