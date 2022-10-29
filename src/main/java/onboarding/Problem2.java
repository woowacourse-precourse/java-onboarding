package onboarding;

public class Problem2 {

    public static boolean validCheck(String str) {
        char[] charArray = str.toCharArray();
        if (str.length() > 1000 || str.length() < 1) {
            return false;
        }
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    public static String deduplicate(String str) {
        StringBuilder builder = new StringBuilder(str);
        int start = 0;
        int end = 0;
        while (true) {
            start = findDuplicateStartIndex(builder);
            if (start == -1) {
                return builder.toString();
            }
            end = findDuplicateEndIndex(builder, start);
            builder.delete(start, end + 1);
        }
    }

    public static int findDuplicateStartIndex(StringBuilder strBuilder) {
        int start;
        for (int i = 1; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == strBuilder.charAt(i - 1)) {
                start = i - 1;
                return start;
            }
        }
        return -1;
    }

    public static int findDuplicateEndIndex(StringBuilder strBuilder, int start) {
        int end = start;
        for (int i = start + 1; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == strBuilder.charAt(start)) {
                end++;
            } else {
                break;
            }
        }
        return end;
    }

    public static String solution(String cryptogram) {
        if (!validCheck(cryptogram)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        String answer = "answer";
        answer = deduplicate(cryptogram);
        return answer;
    }
}
