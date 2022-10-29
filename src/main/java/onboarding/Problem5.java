package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Money.validateMoneyRange(money);
        Money inputMoney = new Money(money);
        answer = ATM.transfer(inputMoney.getWonCountList());
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

class ATM {
    static ArrayList<Integer> transfer(List<Integer> wonCountList) {
        ArrayList<Integer> atmWonCountList = initList(9);
        pushInputToATM(wonCountList, atmWonCountList);
        optimizeCount(atmWonCountList);
        return atmWonCountList;
    }

    private static void optimizeCount(ArrayList<Integer> atmWonCountList) {
        for (int i = atmWonCountList.size() - 1 - 1; i > 0; i--) {
            if (atmWonCountList.get(i) >= 5) {
                atmWonCountList.set(i - 1, atmWonCountList.get(i - 1) + atmWonCountList.get(i) / 5);
                atmWonCountList.set(i, atmWonCountList.get(i) % 5);
            }
        }
    }

    private static void pushInputToATM(List<Integer> wonCountList, ArrayList<Integer> atmWonCountList) {
        for (int i = 0; i < wonCountList.size() - 1; i++) {
            atmWonCountList.set(2 * i, 0);
            atmWonCountList.set(2 * i + 1, wonCountList.get(i));
        }
        atmWonCountList.set(atmWonCountList.size() - 1, wonCountList.get(wonCountList.size() - 1));
    }

    private static ArrayList<Integer> initList(int capacity) {
        ArrayList<Integer> atmWonCountList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            atmWonCountList.add(0);
        }
        return atmWonCountList;
    }

}