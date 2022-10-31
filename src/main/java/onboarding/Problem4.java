package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char tempChar = word.charAt(i);

            if (Character.isUpperCase(tempChar)) {
                int diffVal = tempChar - 'A';
                sb.append((char) ('Z' - diffVal));
            } else if (Character.isLowerCase(tempChar)) {
                int diffVal = tempChar - 'a';
                sb.append((char) ('z' - diffVal));
            } else {
                sb.append(tempChar);
            }
        }

        return sb.toString();
    }
}
