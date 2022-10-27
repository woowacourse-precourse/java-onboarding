package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static String decodeString(String cryptogram) {
        while(!isDecodedSuccess(cryptogram)) {
            cryptogram = cryptogram.replaceAll("(.)\\1+", "");
        }
        String decodedResult = cryptogram;
        return decodedResult;
    }

    public static boolean isDecodedSuccess(String beforeDecodeCryptogram) {
        String afterDecodeCryptogram = decodeString(beforeDecodeCryptogram);
        return beforeDecodeCryptogram.equals(afterDecodeCryptogram);
    }
}
