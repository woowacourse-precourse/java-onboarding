package onboarding.problem2;

public class Cryptographer {
    private String cryptogram;

    public String decrypt(String string) {
        cryptogram = string;
        String result = removeConsecutiveDuplicateFromStringList();

        while (cryptogram.length() != result.length()
                && cryptogram.length() > 0) {
            cryptogram = result;
            result = removeConsecutiveDuplicateFromStringList();
        }

        return cryptogram;
    }

    private String removeConsecutiveDuplicateFromStringList() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            String unduplicatedString = getUnduplicatedString(i);
            result.append(unduplicatedString);
        }
        return result.toString();
    }

    private String getUnduplicatedString(int index) {
        char currentString = cryptogram.charAt(index);

        if (!isDuplicatedWithBefore(index) && !isDuplicatedWithNext(index)) {
            return Character.toString(currentString);
        }

        return "";
    }

    private boolean isDuplicatedWithBefore(int index) {
        if (index == 0) {
            return false;
        }

        char beforeString = cryptogram.charAt(index - 1);
        char currentString = cryptogram.charAt(index);

        return currentString == beforeString;
    }

    private boolean isDuplicatedWithNext(int index) {
        if (index == cryptogram.length() - 1) {
            return false;
        }

        char currentString = cryptogram.charAt(index);
        char nextString = cryptogram.charAt(index + 1);

        return currentString == nextString;
    }
}


