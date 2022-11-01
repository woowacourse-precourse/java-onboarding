package onboarding;

public class Cryptogram {
    private String value;
    private boolean duplicated;

    public Cryptogram(String value) {
        validCryptogram(value);

        this.value = value;
        duplicated = true;

        checkDuplicate();
    }

    private void validCryptogram(String value) {
        if (!value.matches("^[a-z]*$"))
            throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있어야 합니다.");

        if (value.length() < 1 || value.length() > 1000)
            throw new IllegalArgumentException("crpytogram은 1자 이상 1000자 이하여야 합니다.");
    }

    public boolean isDuplicate() {
        return duplicated;
    }

    private void checkDuplicate() {
        int i = 0;

        while (i < value.length() - 1) {
            i = (value.charAt(i) == value.charAt(i + 1)) ?
                    Integer.MAX_VALUE
                    : i + 1;
        }

        duplicated = (Integer.MAX_VALUE == i) ? true : false;
    }

    public String deleteDuplicate() {
        if (!duplicated)
            return value;

        for (int i = 0; i < value.length(); i++) {
            value = value.replaceAll(value.charAt(i) + "{2,}", "");
        }

        checkDuplicate();

        return value;
    }
}
