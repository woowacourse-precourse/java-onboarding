package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        while (true) {

            String nextCryptogram = toDeduplicate(cryptogram);

            if (cryptogram.equals(nextCryptogram)) {
                break;
            }

            cryptogram = nextCryptogram;

            if (cryptogram.isEmpty()) {
                break;
            }
        }

        answer = cryptogram;

        return answer;
    }

    private static String toDeduplicate(String cryptogram) {
        String result = "";

        int size = cryptogram.length();
        String nextCryptogram = cryptogram;

        char prevChar = cryptogram.charAt(0);
        String toBeRemoved = "";

        for (int i = 1; i < size; i++) {

            char currentChar = cryptogram.charAt(i);

            toBeRemoved = getNextRemoved(toBeRemoved, prevChar, currentChar);

            if ((prevChar == currentChar) && (i < size - 1)) {
                continue;
            }

            nextCryptogram = nextCryptogram.replaceAll(toBeRemoved, "");
            prevChar = currentChar;
            toBeRemoved = "";
        }

        result = nextCryptogram;

        return result;
    }

    private static String getNextRemoved(String toBeRemoved, char prev, char cur) {

        String nextRemoved = toBeRemoved;

        if (checkDuplicate(prev, cur)) {
            nextRemoved += cur;
            nextRemoved = (toBeRemoved.length() == 0) ? prev + nextRemoved : nextRemoved;
        }

        return nextRemoved;
    }

    private static boolean checkDuplicate(char prev, char cur) {
        return prev == cur;
    }

}
