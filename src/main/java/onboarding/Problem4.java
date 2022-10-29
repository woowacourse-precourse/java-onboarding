package onboarding;

public class Problem4 {

    public static String solution(String word) {
        Translator translator = Translator.getInstance();
        String answer = translator.translate(word);
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

    public String translate(String word) {
        StringBuilder translated = new StringBuilder();

        for (int len = word.length(), i = 0; i < len; i++) {
            char current = word.charAt(i);
            current = translate(current);
            translated.append(current);
        }

        return translated.toString();
    }

    public char translate(char character) {
        if (Character.isUpperCase(character)) {
            return (char) ('Z' - character + 'A');
        }

        if (Character.isLowerCase(character)) {
            return (char) ('z' - character + 'a');
        }

        return character;
    }

}
