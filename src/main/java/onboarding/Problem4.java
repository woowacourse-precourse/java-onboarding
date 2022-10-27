package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 'a' && c <= 'z') {
                arr[i] = (char) ('a' + 'z' - c);
            } else if (c >= 'A' && c <= 'Z') {
                arr[i] = (char) ('A' + 'Z' - c);
            }
        }
        return String.valueOf(arr);
    }
}
