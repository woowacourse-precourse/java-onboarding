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

        return result;
    }

}
