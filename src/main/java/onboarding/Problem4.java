package onboarding;

public class Problem4 {

    private static final char lowercaseA = 'a';
    private static final char lowercaseZ = 'z';
    private static final char uppercaseA = 'A';
    private static final char uppercaseZ = 'Z';
    private static final int uppercase = 155;
    private static final int lowercase = 219;

    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (isUppercase(current)) {
                stringBuilder.append(reverse(uppercase, current));
                continue;
            }
            if (isLowercase(current)) {
                stringBuilder.append(reverse(lowercase, current));
                continue;
            }
            stringBuilder.append(current);
        }
        return stringBuilder.toString();
    }

    private static char reverse(int standard , char current) {
        return (char) (standard - current);
    }

    private static boolean isLowercase(char current) {
        return current >= lowercaseA && current <= lowercaseZ;
    }

    private static boolean isUppercase(char alphabet) {
        return alphabet >= uppercaseA && alphabet <= uppercaseZ;
    }
}
