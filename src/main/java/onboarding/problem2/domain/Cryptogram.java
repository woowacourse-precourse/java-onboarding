package onboarding.problem2.domain;

import java.util.Objects;

public class Cryptogram {

    public static final String DELETE_CONSECUTIVE_CHARACTER_REGEX = "(([a-z])\\2{1,})";
    private final String cryptogram;

    public Cryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public Cryptogram deleteConsecutiveCharacter() {
        return new Cryptogram(
                this.cryptogram.replaceAll(DELETE_CONSECUTIVE_CHARACTER_REGEX, ""));
    }
    
    public String text() {
        return this.cryptogram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cryptogram that = (Cryptogram) o;
        return Objects.equals(cryptogram, that.cryptogram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cryptogram);
    }
}
