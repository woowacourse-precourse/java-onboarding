package onboarding.Problem1Package;

import java.util.List;

public class Product implements Calc{

    @Override
    public int getCalc(List<Integer> list) {
        int product = list.stream().reduce(1, (a, b) -> a*b);
        return product;
    }
}