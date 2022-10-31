package onboarding;

public class Problem4 {
    public static StringBuilder transform(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char alphabet = word.charAt(i);
            if ('A' <= alphabet && alphabet <= 'Z') {
                int temp = alphabet - 'A';
                stringBuilder.append((char) ('Z' - temp));
            } else if ('a' <= alphabet && alphabet <= 'z') {
                int temp = alphabet - 'a';
                stringBuilder.append((char) ('z' - temp));
            } else {
                stringBuilder.append(alphabet);
                continue;
            }
        }
        return stringBuilder;
    }
    public static String solution(String word) {
        // 1. 각 알파벳
        return String.valueOf(transform(word));
    }
}
