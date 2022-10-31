package onboarding.problem2;

public class Decrypt {

    private final DuplicateProcessor duplicateProcessor;

    public Decrypt(DuplicateProcessor duplicateProcessor) {
        this.duplicateProcessor = duplicateProcessor;
    }

    public String doDecrypt(String cryptogram) {
        return duplicateProcessor.checkDuplication(cryptogram.toCharArray());
    }
}
