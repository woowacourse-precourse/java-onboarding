package onboarding.problem2;

import java.util.Stack;

public class Decryptor {
    String cryptogram;
    Stack<Character> decryptor;

    public Decryptor(String cryptogram) {
        this.cryptogram = cryptogram;
        decryptor = new Stack<>();
    }

    public String decode() {
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            char nextCharacter = cryptogram.charAt(idx);
            if (IsDecryptorThenPush(nextCharacter)) continue;
            if (isDuplicate(nextCharacter)) {
                decryptor.pop();
            }
        }
        return "";
    }

    private boolean IsDecryptorThenPush(char nextCharacter) {
        if (decryptor.empty()) {
            decryptor.push(nextCharacter);
            return true;
        }
        return false;
    }
    private boolean isDuplicate(char next){
        if (decryptor.peek() == next) {
            return true;
        }
        return false;
    }
}
