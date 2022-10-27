package onboarding.problem2;

import java.util.Stack;

public class Decryptor {
    String cryptogram;
    Stack<Character> decryptor;
    Character deletedCharacter;

    public Decryptor(String cryptogram) {
        this.cryptogram = cryptogram;
        decryptor = new Stack<>();
    }

    public String result() {
        decode();

        StringBuilder sb = new StringBuilder();
        for (char character : decryptor) {
            sb.append(character);
        }
        return sb.toString();
    }

    private void decode() {
        for (int idx = 0; idx < cryptogram.length(); idx++) {
            char nextCharacter = cryptogram.charAt(idx);

            if (isDuplicateWithDeletedCharacter(nextCharacter)) continue;
            if (IsDecryptorEmptyThenPush(nextCharacter)) continue;
            if (isDuplicateWithTopOfDecrypterCharacterThenDelete(nextCharacter)) continue;

            decryptor.push(nextCharacter);
        }
    }

    private boolean isDuplicateWithDeletedCharacter(char nextCharacter) {
        if (deletedCharacter != null && deletedCharacter == nextCharacter) {
            return true;
        }
        return false;
    }

    private boolean IsDecryptorEmptyThenPush(char nextCharacter) {
        if (decryptor.empty()) {
            decryptor.push(nextCharacter);
            return true;
        }
        return false;
    }

    private boolean isDuplicateWithTopOfDecrypterCharacterThenDelete(char next) {
        if (decryptor.peek() == next) {
            decryptor.pop();
            deletedCharacter = next;
            return true;
        }
        return false;
    }
}
