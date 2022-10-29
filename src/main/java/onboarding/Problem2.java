package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}

class Decrypter {

    private static class DecrypterHolder {
        private static final Decrypter INSTANCE = new Decrypter();
    }

    private Decrypter() {
    }

    public static Decrypter getInstance() {
        return DecrypterHolder.INSTANCE;
    }

}