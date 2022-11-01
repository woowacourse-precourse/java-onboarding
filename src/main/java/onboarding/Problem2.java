package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decryptor decryptor = new Decryptor(cryptogram);
        return decryptor.getAllRemovedDuplicatedString();
    }

}
