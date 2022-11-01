package onboarding.Problem4Package;

public class LowerCase implements Alphabet {

    int asciiStart = 65;
    int asciiEnd = 90;

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
