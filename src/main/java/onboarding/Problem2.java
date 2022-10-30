package onboarding;

public class Problem2 {
    public static String removeDuplicateChars(String string) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < (string.length() -1) ; index++) {
            if (string.charAt(index) != string.charAt(index + 1)) {
                result.append(string.charAt(index));
            }
            if (string.charAt(index) == string.charAt(index + 1)) {
                index++;
            }
        }

        return result.toString();
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
