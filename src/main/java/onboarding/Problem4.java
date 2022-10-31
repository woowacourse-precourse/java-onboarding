package onboarding;
/*
abcdefghijklmnopqrstuvwxyz
zyxwvutsrqponmlkjihgfedcba
 */

public class Problem4 {
    static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static String solution(String word) {
        String answer = "";
        StringBuilder alphaReverse = new StringBuilder(ALPHA).reverse();

        char[] ch = word.toCharArray();

        for (char c : ch) {
            //알파벳 확인
            if (!Character.isAlphabetic(c)) {
                answer += c;
                continue;
            }

            //대문자
            if (Character.isUpperCase(c)) {
                String alphaUpperCase = ALPHA.toUpperCase();

                for (int i = 0; i < alphaUpperCase.length(); i++) {
                    if (c == alphaUpperCase.charAt(i)) {
                        String temp = "" + alphaReverse.charAt(i);
                        answer += temp.toUpperCase();
                    }
                }
            }

            //소문자
            if (Character.isLowerCase(c)) {
                for (int i = 0; i < ALPHA.length(); i++) {
                    if (c == ALPHA.charAt(i)) {
                        answer += alphaReverse.charAt(i);
                    }
                }
            }
        }

        return answer;
    }
}
