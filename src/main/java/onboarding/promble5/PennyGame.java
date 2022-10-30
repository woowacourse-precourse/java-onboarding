package onboarding.promble5;

import java.util.ArrayList;
import java.util.List;

public class PennyGame {

    public static List<Integer> start(int money) {
        List<Integer> result = new ArrayList<>();
        Penny.getPennyResult(money,result);
        return result;
    }
}
