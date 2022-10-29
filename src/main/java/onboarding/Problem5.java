package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class Input5 {
    static int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}

class Money {
    private final int origin;
    private int oneMillionWon;
    private int oneThousandWon;
    private int oneHundredWon;
    private int tenWon;
    private int oneWon;

    Money(int origin) {
        this.origin = origin;
        this.oneMillionWon = this.origin / 10000;
        this.oneThousandWon = this.origin / 1000 % 10;
        this.oneHundredWon = this.origin / 100 % 10;
        this.tenWon = this.origin / 10 % 10;
        this.oneWon = this.origin % 10;
    }

    public int getOrigin() {
        return origin;
    }

    public int getOneMillionWon() {
        return oneMillionWon;
    }

    public int getOneThousandWon() {
        return oneThousandWon;
    }

    public int getOneHundredWon() {
        return oneHundredWon;
    }

    public int getTenWon() {
        return tenWon;
    }

    public int getOneWon() {
        return oneWon;
    }

    static void validateMoneyRange(int money) {
        if (money < 1 || 1000000 < money) {
            throw new IllegalStateException("1이상 1,000,000 이하로 입력해 주세요");
        }
    }

    public ArrayList<Integer> getWonCountList() {
        ArrayList<Integer> wonCountList = new ArrayList<>();
        wonCountList.add(oneMillionWon);
        wonCountList.add(oneThousandWon);
        wonCountList.add(oneHundredWon);
        wonCountList.add(tenWon);
        wonCountList.add(oneWon);
        return wonCountList;
    }
}