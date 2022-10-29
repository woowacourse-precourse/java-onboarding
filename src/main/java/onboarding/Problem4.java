package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

}

class Translator {

    private static class TranslatorHolder {
        private static final Translator INSTANCE = new Translator();
    }

    private Translator() {
    }

    public static Translator getInstance() {
        return TranslatorHolder.INSTANCE;
    }

}
