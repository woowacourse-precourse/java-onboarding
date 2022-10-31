package onboarding.probelm2;

public class CryptogramGenerator {
    private StringBuilder cryptogram;

    public CryptogramGenerator(String cryptogram) {
        this.cryptogram = new StringBuilder(cryptogram);
    }

    private boolean isSameWithNext(int i) {
        return i < cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1);
    }

    private boolean isSameWithBefore(int i) {
        return i > 0 && cryptogram.charAt(i) == cryptogram.charAt(i - 1);
    }

    private boolean checkAndRemoveSameCharacter() {
        boolean check = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); i++) {
            Character character = cryptogram.charAt(i);
            if (isSameWithBefore(i) || isSameWithNext(i)) {
                check = true;
                continue;
            }
            result.append(character);
        }
        if (check) cryptogram = result;
        return check;
    }

    public String generate() {
        while (checkAndRemoveSameCharacter()) ;
        return cryptogram.toString();
    }
}
