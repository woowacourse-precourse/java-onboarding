package onboarding.validation;

import java.util.List;

public class NumberValidate {

    public static Boolean rangeValidate(Integer min, Integer i, Integer max) {
        if (min <= i && i <= max) {
            return true;
        }
        return false;
    }

    public static Boolean mod0Validate(Integer i, Integer divisor) {
        if (i % divisor == 0) {
            return true;
        }
        return false;
    }

    public static Boolean bookValidate(List<Integer> lst) {
        if (lst.get(0) + 1 == lst.get(1) && mod0Validate(lst.get(1), 2)) {
            return true;
        }
        return false;
    }

}
