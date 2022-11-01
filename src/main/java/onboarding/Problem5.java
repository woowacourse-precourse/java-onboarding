package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        answer.add(fiftyThousandFilter(money));
        money = money - (fiftyThousandFilter(money) * 50000);

        answer.add(tenThousandFilter(money));
        money = money - (tenThousandFilter(money) * 10000);

        answer.add(fiveThousandFilter(money));
        money = money - (fiveThousandFilter(money) * 5000);

        answer.add(oneThousandFilter(money));
        money = money - (oneThousandFilter(money) * 1000);

        answer.add(fiveHundredFilter(money));
        money = money - (fiveHundredFilter(money) * 500);

        answer.add(oneHundredFilter(money));
        money = money - (oneHundredFilter(money) * 100);

        answer.add(fiftyFilter(money));
        money = money - (fiftyFilter(money) * 50);

        answer.add(tenFilter(money));
        money = money - (tenFilter(money) * 10);

        answer.add(oneFilter(money));

        return answer;
    }//public static List<Integer> solution

    public static int fiftyThousandFilter(int money){
        return money / 50000;
    }//public static int fiftyThousandFilter

    public static int tenThousandFilter(int money){
        return money / 10000;
    }//public static int tenThousandFilter

    public static int fiveThousandFilter(int money){
        return money / 5000;
    }//public static int fiveThousandFilter

    public static int oneThousandFilter(int money){
        return money / 1000;
    }//public static int oneThousandFilter

    public static int fiveHundredFilter(int money){
        return money / 500;
    }//public static int fiveHundredFilter

    public static int oneHundredFilter(int money){
        return money / 100;
    }//public static int oneHundredFilter

    public static int fiftyFilter(int money){
        return money / 50;
    }//public static int fiftyFilter

    public static int tenFilter(int money){
        return money / 10;
    }//public static int tenFilter

    public static int oneFilter(int money){
        return money;
    }//public static int oneFilter

}//public class Problem5

