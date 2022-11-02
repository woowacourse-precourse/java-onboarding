package problem3;

import java.util.List;

public class Game {
    private final int number;
    private final List<Character> clapNumbers = List.of('3', '6', '9');
    private int clap;

    public Game(int number) {
        this.number = number;
        this.clap = 0;
        Validator validator = new Validator(number);
        validator.validate();
    }

    public int run() {
        for(int i = 1; i <= number; i++) {
            String compareNumber = String.valueOf(i);
            compareClapNumber(compareNumber);
        }
        return clap;
    }

    private void compareClapNumber(String compareNumber) {
        for(int i = 0; i < compareNumber.length(); i++) {
            countClap(compareNumber, i);
        }
    }

    private void countClap(String compareNumber, int index) {
        if(hasNumber(compareNumber, index)) {
            clap += 1;
        }
    }

    private boolean hasNumber(String compareNumber, int index) {
        return clapNumbers.contains(compareNumber.charAt(index));
    }
}
