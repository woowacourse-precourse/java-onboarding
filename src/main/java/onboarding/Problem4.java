package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = word.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(isUpperCase(charArray[i])) {
                sb.append((char)('Z' + 'A' - charArray[i]));
            } else if(isLowerCase(charArray[i])) {
                sb.append((char)('z' + 'a' - charArray[i]));
            } else {
                sb.append(charArray[i]);
            }
        }

        return sb.toString();
    }

    private static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
}
