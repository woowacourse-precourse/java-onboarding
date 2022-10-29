package onboarding.validation;

public class MinMaxIntegerInputValidate implements MinMaxInputValidatable{
    @Override
    public boolean isInputBetweenMinAndMax(Object object, int min, int max) {
        Integer userIntegerInput = (Integer) object;
        return (min <= userIntegerInput && userIntegerInput <= max);
    }
}
