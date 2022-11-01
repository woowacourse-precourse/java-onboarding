package model;

public class ClapGame {
    private final int settingNum;
    private int clapNumber;

    public ClapGame(int number) {
        this.settingNum = number;
        this.clapNumber = 0;
    }

    public void start() {
        for (int i = 1; i <= this.settingNum; i++) {
            decomposed(i);
        }
    }

    void decomposed(int decomposedNum) {
        while (decomposedNum > 0) {
            clap(decomposedNum % 10);
            decomposedNum /= 10;
        }
    }

    void clap(int eachDigit) {
        if (eachDigit == 3 || eachDigit == 6 || eachDigit == 9)
            this.clapNumber++;
    }

    public int getClapNumber() {
        return this.clapNumber;
    }
}
