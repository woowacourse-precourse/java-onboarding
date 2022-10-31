package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] alphabets = word.toCharArray();

        for (char alphabet : alphabets) {
            if (isAlphabet(alphabet)) {
                // sb.append(변환된 알파벳);
                continue;
            }

            sb.append(alphabet);
        }

        return sb.toString();
    }

    private static boolean isAlphabet(char alphabet) {
        if ('A' <= alphabet && alphabet <= 'Z') {
            return true;
        }

        if ('a' <= alphabet && alphabet <= 'z') {
            return true;
        }

        return false;
    }
}
