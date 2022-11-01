package onboarding.Problem1Package;

import java.util.List;

public class Sum implements Calc {

    @Override
    public int getCalc(List<Integer> list) {
        int sum = list.stream().reduce(0, (a, b) -> a+b);
        return sum;
    }
}