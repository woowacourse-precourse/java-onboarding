package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            convert(arr, i);
        }
        return new String(arr);
    }

    private static void convert(char[] arr, int i) {
        if (arr[i] >= 'a' && arr[i] <= 'z') {
            int diff = 'z' - arr[i];
            arr[i] = (char) ('a' + diff);
        } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
            int diff = 'Z' - arr[i];
            arr[i] = (char) ('A' + diff);
        }
    }
}
