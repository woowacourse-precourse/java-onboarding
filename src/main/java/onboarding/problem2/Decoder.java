package onboarding.problem2;

public class Decoder {
    private final Cipher cipherText;

    public Decoder(Cipher cipherText) {
        this.cipherText = cipherText;
    }

    public String decode() {
        StringBuilder beforeRemove = cipherText.getBuilder();
        int beforeLength = beforeRemove.length();

        while (beforeLength > removeConsecutive(beforeRemove).length()) {
            beforeLength = beforeRemove.length();
        }
        return beforeRemove.toString();
    }

    private StringBuilder removeConsecutive(StringBuilder cipher) {
        for (int last = cipher.length() - 1; last >= 0; last--) {
            int deleteStart = new ConsecutiveFinder(cipher).findConsequence(last);
            new Deleter(cipher).delete(new RangeDto(deleteStart, last));
            last = deleteStart;
        }
        return cipher;
    }
}
