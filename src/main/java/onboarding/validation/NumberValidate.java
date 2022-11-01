package onboarding.validation;

import java.util.List;

public class NumberValidate {

    public static boolean rangeValidate(Integer min, Integer i, Integer max) {
        return min <= i && i <= max;
    }

    public static boolean mod0Validate(Integer i, Integer divisor) {
        return i % divisor == 0;
    }

    public static boolean bookValidate(List<Integer> lst) {
        return lst.get(0) + 1 == lst.get(1) && mod0Validate(lst.get(1), 2);
    }

}
