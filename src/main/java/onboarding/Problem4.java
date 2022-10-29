package onboarding;

public class Problem4 {
    public static String solution(String word) {

        char[] decode = word.toCharArray();

        for (int i = 0; i < decode.length; i++) {

            if(Character.isUpperCase(decode[i])) {
                decode[i] = (char) ('A' + 'Z' - decode[i]);
            }
            else if(Character.isLowerCase(decode[i])) {
                decode[i] = (char) ('a' + 'z' - decode[i]);
            }

        }

        return new String(decode);
    }

}
