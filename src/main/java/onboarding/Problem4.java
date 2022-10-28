package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char c;

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if(Character.isUpperCase(c)) {
                sb.append(convertUpper(c));
                continue;
            }

            if(Character.isLowerCase(c)) {
                sb.append(convertLower(c));
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    private static char convertUpper(char c) {
        int ascii = c;

        return (char) (Math.abs(ascii - 90) + 65);
    }

    private static char convertLower(char c) {
        int ascii = c;

        return (char) (Math.abs(ascii - 122) + 97);
    }
}
