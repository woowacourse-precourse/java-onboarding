package problem3;

import java.util.List;

public class Game {
    private final int number;
    private final List<String> clapNumbers = List.of("3", "6", "9");
    private int clap = 0;

    public Game(int number) {
        this.number = number;
    }

    public int countClap() {
        for(int i = 1; i <= number; i++) {
            String compareNumber = String.valueOf(number);
            for(String clapNumber : clapNumbers) {
                if(compareNumber.contains(clapNumber)) {
                    clap += 1;
                }
            }
        }
        return clap;
    }
}
