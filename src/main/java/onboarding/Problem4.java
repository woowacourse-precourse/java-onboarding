package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            sb.append(translate((int) word.charAt(i)));
        }

        return sb.toString();
    }

    public static char translate(int c_int) {
        if (65 <= c_int && c_int <= 90) {
            return (char) (155 - c_int);
        } else if (97 <= c_int && c_int <= 122) {
            return (char) (219 - c_int);
        } else {
            return (char) c_int;
        }
    }
}
