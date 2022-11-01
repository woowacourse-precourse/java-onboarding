package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);

        return answer;
    }

    private static String deduplicate(String s) {
        return s.replaceAll("(([a-zA-Z\\d])\\2+)", "");
    }

    private static String decrypt(String cryptogram) {
        String deduplication = deduplicate(cryptogram);

        if(deduplication.equals(cryptogram)){
            return deduplication;
        }

        return decrypt(deduplication);
    }
}
