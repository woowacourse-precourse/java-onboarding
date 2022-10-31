package onboarding.validation;

import java.util.List;

public class MinMaxListInputValidate implements MinMaxInputValidatable{
    private static final MinMaxListInputValidate minMaxListInputValidate = new MinMaxListInputValidate();

    private MinMaxListInputValidate() {

    }
    public static MinMaxListInputValidate getMinMaxListInputValidate() {
        return minMaxListInputValidate;
    }

    @Override
    public boolean isInputBetweenMinAndMax(Object object, int min, int max) {
        List list = (List) object;
        return (min <= list.size() && list.size() <= max);
    }
}
