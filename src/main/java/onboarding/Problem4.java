package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] values = word.toCharArray();

        for (int i = 0; i < values.length; i++) {
            values[i] = changer(values[i]);
        }
        
        return new String(values);
    }

    public static char changer(char text) {
        if (123 > text && text > 96) {
            int test = text - 97;
            return Character.toChars(122 - test)[0];
        } else if (91 > text && text > 64) {
            int test = text - 65;
            return Character.toChars(90 - test)[0];
        } else {
            return text;
        }
    }
}
