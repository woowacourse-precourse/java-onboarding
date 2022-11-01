package onboarding;

public class Problem4 {

    public static String solution(String word) {
        Problem4 p4 = new Problem4();
        return p4.invertCharacter(word);
    }

    private String invertCharacter(String str) {
        StringBuilder sb = new StringBuilder();
        final int upperMid = 77;
        final int lowerMid = 109;

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append((char) (2 * lowerMid + 1 - c));
                continue;
            }
            if (Character.isUpperCase(c)) {
                sb.append((char) (2 * upperMid + 1 - c));
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

}
