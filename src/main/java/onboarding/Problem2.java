package onboarding;

class Decoder {
    private String cryptogram;

    Decoder(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public boolean removeRepeatedChar() {
        String removeRepeatedString = "";
        boolean isDuplicatedAlphabet = false;
        Character charBox = null;

        for (int i = 0; i < cryptogram.length(); i++) {
            char ch = cryptogram.charAt(i);

            if (charBox != null && charBox == ch) {
                isDuplicatedAlphabet = true;
                continue;
            }

            if (charBox != null && !isDuplicatedAlphabet) {
                removeRepeatedString += charBox;
            }

            charBox = ch;
            isDuplicatedAlphabet = false;
        }

        if(!isDuplicatedAlphabet) {
            removeRepeatedString += charBox;
        }

        boolean flag = removeRepeatedString.length() != cryptogram.length();
        if (flag) {
            cryptogram = removeRepeatedString;
        }

        return flag;
    }

    public String decode() {
        while (cryptogram.length() > 0 && removeRepeatedChar()) {
            removeRepeatedChar();
        }
        return cryptogram;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        Decoder decoder = new Decoder(cryptogram);
        return decoder.decode();
    }
}
