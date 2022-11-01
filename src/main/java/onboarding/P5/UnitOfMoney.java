package onboarding.P5;

import java.util.List;

public class UnitOfMoney {
    private static final List<Integer> coinlist = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> unitofmoneylist(){
        return coinlist;
    }
}
