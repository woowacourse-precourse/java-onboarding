package onboarding.Problem4Package;

public class UpperCase implements Alphabet {

    int asciiStart = 97;
    int asciiEnd = 122;

    @Override
    public Boolean isTrue(char inputChar) {
        return (asciiStart <= inputChar && inputChar <= asciiEnd) ?  Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public char translateAlphabetByFrog(char input) {
        int inputChar = (int) input;
        int sumAscii = asciiStart + asciiEnd;

        return (char)(sumAscii - inputChar);
    }
}
