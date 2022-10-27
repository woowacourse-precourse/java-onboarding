package utils;


public class Problem4Util {
    public static char transform(char ch) {
        if (Character.isLowerCase(ch)) {
            return (char) ('z' - (ch - 'a'));

        } else if (Character.isUpperCase(ch)) {
            return (char) ('Z' - (ch - 'A'));
        }
        return ' ';
    }
}
