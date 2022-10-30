package onboarding;

public class Problem2 {
    public static boolean checkExistDuplicateChars(String string) {
        for (int index = 0; index < (string.length() - 1) ; index++) {
            if (string.charAt(index) == string.charAt(index + 1)) {
                return true;
            }
        }

        return false;
    }

    public static String removeDuplicateChars(String string) {
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < (string.length() - 1) ; index++) {
            if (string.charAt(index) != string.charAt(index + 1)) {
                result.append(string.charAt(index));
            }
            if (string.charAt(index) == string.charAt(index + 1)) {
                index++;
            }
        }
        if (string.charAt(string.length() - 2) != string.charAt(string.length() - 1)) {
            result.append(string.charAt(string.length() - 1));
        }
        
        return result.toString();
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        while (checkExistDuplicateChars(cryptogram)) {
            cryptogram = removeDuplicateChars(cryptogram);
        }
        answer = cryptogram;

        return answer;
    }
}
