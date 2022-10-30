package onboarding.problem5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WonAtm implements Atm{

    private final Integer[] cashTypes;

    public WonAtm(Integer[] cashTypes) {
        this.cashTypes = cashTypes;
    }


    @Override
    public List<Integer> exchange(int money) {
        List<Integer> result = obtainDefaultResultList();
        for(int i = 0; i < this.cashTypes.length; i++) {
            result.set(i, money/cashTypes[i]);
            money %= cashTypes[i];
        }
        return result;
    }

    private List<Integer> obtainDefaultResultList() {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < this.cashTypes.length; i++) {
            result.add(0);
        }
        return result;
    }
}
