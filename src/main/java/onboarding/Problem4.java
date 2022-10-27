package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        // A (65) ~ Z (90) 77 78
        // a (97) ~ z (122) 109 110
        // b 98 y 121
        // c 99 x 120

        char[] chars = word.toCharArray();

        for (char aChar : chars) {
            answer += (char)reverse(aChar);
        }

        return answer;
    }

    static int reverse(int c) {

        if (c >= 77 && c <=90) {
            return (char) (90 - (c - 65));
        }
        if (c >= 65 && c <= 78 ) {
            return (char) (65 + (90 - c));
        }
        if (c >= 109 && c <=122) {
            return (char) (122-(c-97));
        }
        if (c >= 97 && c <= 110 ) {
            return (char) (97 + (122-c));
        }

        return c;
    }
}
