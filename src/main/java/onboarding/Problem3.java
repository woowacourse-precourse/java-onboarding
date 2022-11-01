package onboarding;

import java.util.Arrays;
import java.util.HashSet;

public class Problem3 {

    public static int solution(int number) {
        
        Number input = new Number(number);
        Score3 score = new Score3(0);
        for (int i = 1; i <= input.getNumber(); i++) {
            Clap clap = new Clap(i);
            score.addScore(clap.getClapCount());
        }
        return score.getScore();
    }
}

class Number {

    private final int number;

    public Number(int input) {
        validateSize(input);
        this.number = input;
    }

    private void validateSize(int input) {
        if(input < 1) {
            throw new IllegalArgumentException("1이상 값을 입력하세요.");
        }
        if (input > 10000) {
            throw new IllegalArgumentException("10000이하 값을 입력하세요");
        }
    }

    public int getNumber(){
        return this.number;
    }
}

class Clap {

    private static final HashSet<Integer> set369 = new HashSet<>(Arrays.asList(3,6,9));

    private final int number;

    public Clap(int number){
        this.number = number;
    }

    public int getClapCount() {
        int n;
        int count = 0;
        int temp = number;
        while (temp > 0) {
            n = temp % 10;
            if (set369.contains(n)) {
                count++;
            }
            temp /= 10;
        }
        return count;
    }
}

class Score3 {
    private int score;

    public Score3(int score) {
        this.score = score;
    }

    public void addScore(int score ) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }
}



