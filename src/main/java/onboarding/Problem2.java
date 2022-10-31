package onboarding;

public class Problem2 {
    private static String removeDuplication(String inputString) {
        String removedString = "";
        boolean signal = false;

        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == inputString.charAt(i+1)) {
                removedString += inputString.substring(0, i);
                removedString += inputString.substring(i+2);
                signal = true;
                break;
            }
        }

        if (!signal) {
            return inputString;
        }

        return removedString;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        String inputString = cryptogram;
        String modifiedString;

        while (true) {
            modifiedString = removeDuplication(inputString);

            if (modifiedString.equals(inputString)) {
                break;
            }

            inputString = modifiedString;
        }

        answer = modifiedString;

        return answer;
    }
}
