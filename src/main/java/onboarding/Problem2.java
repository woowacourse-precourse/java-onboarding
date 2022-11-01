package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = removeDuplicateAlphabet(cryptogram);

        return answer;
    }

    public static String removeDuplicateAlphabet(String cryptogram) {
        StringBuffer str = new StringBuffer(cryptogram);
        int index = 0;
        int duplicateLength = 1;
        boolean flag = true;

        for (int i = 0; i < str.length() - 1; i++) {
            char startChar = str.charAt(i);
            if (startChar == str.charAt(i + 1)) {
                for (int j = i; j < str.length() - 1; j++) {
                    if (startChar == str.charAt(j + 1)) {
                        duplicateLength += 1;
                    } else {
                        break;
                    }
                }
                str.delete(i, i + duplicateLength);
                duplicateLength = 1;
                i = i - 2;
            }
            if (i < 0) {
                i = -1;
            }
        }

        cryptogram = str.toString();
        return cryptogram;
    }
}
