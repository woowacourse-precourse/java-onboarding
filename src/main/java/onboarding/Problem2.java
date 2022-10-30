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

        char checkCharacter = cryptogram.charAt(0);
        String toBeRemoved = "";

        for (int i = 1; i < size; i++) {

            char currentChar = cryptogram.charAt(i);

            if (checkCharacter == currentChar) {
                if (toBeRemoved.length() == 0) {
                    toBeRemoved = cryptogram.substring(i - 1, i + 1);
                } else if (toBeRemoved.length() > 0) {
                    toBeRemoved += currentChar;
                }
            }

            // 갱신
            if ((checkCharacter != currentChar) || (i == size - 1)) {
                checkCharacter = currentChar;

                if (toBeRemoved.length() > 0) {
                    nextCryptogram = nextCryptogram.replaceAll(toBeRemoved, "");
                    toBeRemoved = "";
                }
            }

        }

        result = nextCryptogram;

        return result;
    }

}
