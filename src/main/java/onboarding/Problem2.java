package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Cryptogram cryptogram1 = new Cryptogram(cryptogram);

        while (cryptogram1.isDuplicate()) {
            answer = cryptogram1.deleteDuplicate();
        }

        return answer;
    }
}
