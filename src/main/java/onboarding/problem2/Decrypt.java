package onboarding.problem2;

import static onboarding.problem2.CryptogramValidation.*;

public class Decrypt {

    private final DuplicateProcessor duplicateProcessor;

    public Decrypt(DuplicateProcessor duplicateProcessor) {
        this.duplicateProcessor = duplicateProcessor;
    }

    public String doDecrypt(String cryptogram) {
        validateCryptogram(cryptogram);

        char[] cryptoCharArr = cryptogram.toCharArray();

        while (duplicateProcessor.flag()) {
            cryptoCharArr = duplicateProcessor.checkDuplication(cryptoCharArr);
        }

        return StringConverter.charArrToString(cryptoCharArr);
    }
}
