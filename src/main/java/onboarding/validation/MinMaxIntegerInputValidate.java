package onboarding.validation;

public class MinMaxIntegerInputValidate implements MinMaxInputValidatable{

    private static final MinMaxIntegerInputValidate minMaxIntegerInputValidate = new MinMaxIntegerInputValidate();

    private MinMaxIntegerInputValidate() {

    }

    public static MinMaxIntegerInputValidate getMinMaxIntegerInputValidate() {
        return minMaxIntegerInputValidate;
    }

    @Override
    public boolean isInputBetweenMinAndMax(Object object, int min, int max) {
        Integer userIntegerInput = (Integer) object;
        return (min <= userIntegerInput && userIntegerInput <= max);
    }
}
