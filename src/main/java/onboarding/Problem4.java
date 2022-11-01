package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = convertWord(word);

        return answer;
    }

    //소문자 1 대문자 2 그외 -1로  문자 구분
    private static int divideChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            return 2;
        }

        return -1;
    }

    private static char convertLowerCase(char c) {
        int i = c - 'a';

        return (char) ('z' - i);
    }

    private static char convertUpperCase(char c) {
        int i = c - 'A';

        return (char) ('Z' - i);
    }

    private static String convertWord(String word) {
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int d = divideChar(arr[i]);

            if (d == 1) {
                arr[i] = convertLowerCase(arr[i]);
            }

            if (d == 2) {
                arr[i] = convertUpperCase(arr[i]);
            }
        }

        return new String(arr);
    }
}
