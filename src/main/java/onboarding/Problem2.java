package onboarding;

import java.util.ArrayDeque;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        Game2 game2=new Game2(answer);
        return game2.gameResult();
    }
}

class Cryptogram {
    private static final int CRYPTOGRAM_MIN_LENGTH = 1;
    private static final int CRYPTOGRAM_MAX_LENGTH = 1000;
    private static final String NOT_ALLOWED_CRYPTOGRAM_UNDER_MIN_LENGTH = "암호문은 최소 1글자입니다.";
    private static final String NOT_ALLOWED_CRYPTOGRAM_OVER_MAX_LENGTH = "암호문은 최대 1000글자입니다.";
    private static final String ONLY_ALLOWED_CRYPTOGRAM_LOWER_CASE = "암호문은 소문자로만 이루어져 있어야 합니다.";
    private final String cryptogram;

    public Cryptogram(String cryptogram) {
        validateCryptogramLength(cryptogram);
        validateCryptogramLowerCase(cryptogram);
        this.cryptogram = cryptogram;
    }

    private void validateCryptogramLength(String cryptogram) {
        if (cryptogram.length() < CRYPTOGRAM_MIN_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_CRYPTOGRAM_UNDER_MIN_LENGTH);
        }
        if (cryptogram.length() > CRYPTOGRAM_MAX_LENGTH) {
            throw new IllegalStateException(NOT_ALLOWED_CRYPTOGRAM_OVER_MAX_LENGTH);
        }
    }

    private void validateCryptogramLowerCase(String cryptogram) {
        if (cryptogram != cryptogram.toLowerCase()) {
            throw new IllegalStateException(ONLY_ALLOWED_CRYPTOGRAM_LOWER_CASE);
        }
    }

    public char[] toCharArray() {
        return cryptogram.toCharArray();
    }
}

class Decoder {
    public String decode(Cryptogram cryptogram) {
        ArrayDeque<Character> cryptogramQueue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : cryptogram.toCharArray()) {
            if (cryptogramQueue.isEmpty()) {
                cryptogramQueue.addLast(c);
                continue;
            }
            char lastLetter = cryptogramQueue.removeLast();
            if (c != lastLetter) {
                cryptogramQueue.add(lastLetter);
                cryptogramQueue.add(c);
            }
        }
        cryptogramQueue.forEach(sb::append);
        return sb.toString();
    }
}

class Game2{
    private final Cryptogram cryptogram;

    public Game2(String plainText){
        cryptogram=new Cryptogram(plainText);
    }

    public String gameResult(){
        Decoder decoder = new Decoder();
        return decoder.decode(cryptogram);
    }
}
