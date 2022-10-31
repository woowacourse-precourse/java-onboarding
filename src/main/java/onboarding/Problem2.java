package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return "";
    }

    private static boolean[] checkDuplicate(String str) {
        int strLen = str.length();
        boolean[] duplicate = new boolean[strLen];

        int left = 0;
        int right = 1;

        while (right < strLen) {
            if ((str.charAt(left) == str.charAt(right))) {
                duplicate[left] = true;
                duplicate[right] = true;
                right++;

                while (right < strLen && str.charAt(left) == str.charAt(right)) {
                    duplicate[right] = true;
                    right++;
                }
            }
            left = right;
            right++;
        }

        return duplicate;
    }
}
