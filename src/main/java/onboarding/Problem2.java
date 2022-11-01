package onboarding;

public class Problem2 {
    private static String removeDuplication(String inputString) {
        String modifiedString = "";
        int[] arr= new int[inputString.length()];

        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == inputString.charAt(i+1)) {
                arr[i] = -1;
                arr[i+1] = -1;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                modifiedString += inputString.charAt(j);
            }
        }

        return modifiedString;
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
