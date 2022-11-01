package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Lists;

public class MoneyParser {
    private final int[] monetaryUnits;

    public MoneyParser(int...monetaryUnits){
        this.monetaryUnits = monetaryUnits;
    }

    public List<Integer> parseMoney(int money){
        List<Integer> parsedMoney = new ArrayList<>();

        for(int monetaryUnit : monetaryUnits){
            parsedMoney.add(money / monetaryUnit);
            money %= monetaryUnit;
        }

        return parsedMoney;
    }
}
