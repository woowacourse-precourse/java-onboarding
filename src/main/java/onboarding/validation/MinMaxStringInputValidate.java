package onboarding.validation;

public class MinMaxStringInputValidate implements MinMaxInputValidatable{
    @Override
    public boolean isInputBetweenMinAndMax(Object object, int min, int max) {
        String userStringInput = (String) object;
        return (min <= userStringInput.length() && userStringInput.length() <= max);
    }
}
