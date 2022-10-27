package onboarding;

public class Cryptogram {
    private String value;
    private boolean duplicated;

    public Cryptogram(String value) {
        this.value = value;
        duplicated = true;

        checkDuplicate();
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
        String str = value;
        if (!duplicated)
            return value;

        for (int i = 0; i < value.length(); i++) {
            value = value.replaceAll(value.charAt(i) + "{2,}", "");
        }

        checkDuplicate();

        return value;
    }
}
