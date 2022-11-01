package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {
            String inputStr = cryptogram;

            String outputStr = removeRedundantSequence(inputStr);

            if (outputStr.equals("")) {
                answer = "";
                break;
            }

            if (inputStr.equals(outputStr)) {
                answer = outputStr;
                break;
            }

            cryptogram = outputStr;
        }

        return answer;
    }

    private static String removeRedundantSequence(String crypto) {
        StringBuilder sb = new StringBuilder();

        if (crypto.charAt(0) == crypto.charAt(1)) {
            if (crypto.length() == 2) {
                return "";
            }

            sb.append(crypto.substring(2));

            return sb.toString();
        }

        for (int i = 1; i < crypto.length() -2; i++) {
            if (crypto.charAt(i) == crypto.charAt(i + 1)) {
                sb.append(crypto, 0, i);
                sb.append(crypto.substring(i + 2));

                return sb.toString();
            }
        }

        if (crypto.charAt(crypto.length() - 2) == crypto.charAt(crypto.length() - 1)) {
            sb.append(crypto, 0, crypto.length() - 2);

            return sb.toString();
        }

        return crypto;
    }
}
