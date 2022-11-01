package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int code = (int) arr[i];
            if (code >= 65 && code <= 90) {
                code = 155 - code;
            } else if (code >= 96 && code <= 122) {
                code = 219 - code;
            }
            arr[i] = (char) code;
        }

        word = new String(arr);

        answer = word;

        return answer;
    }
}
