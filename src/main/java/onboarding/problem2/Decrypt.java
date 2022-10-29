package onboarding.problem2;

import static onboarding.problem2.CryptogramValidator.*;

public class Decrypt {

    private final DuplicateProcessor duplicateProcessor;

    public Decrypt(DuplicateProcessor duplicateProcessor) {
        this.duplicateProcessor = duplicateProcessor;
    }

    public String doDecrypt(String cryptogram) {
        validateCryptogram(cryptogram);
        return duplicateProcessor.checkDuplication(cryptogram.toCharArray());
    }
}
