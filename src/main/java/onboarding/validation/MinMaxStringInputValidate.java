package onboarding.validation;

public class MinMaxStringInputValidate implements MinMaxInputValidatable{
    private static MinMaxStringInputValidate minMaxStringInputValidate = new MinMaxStringInputValidate();

    private MinMaxStringInputValidate() {

    }

    public static MinMaxStringInputValidate getMinMaxStringInputValidate() {
        return minMaxStringInputValidate;
    }
    @Override
    public boolean isInputBetweenMinAndMax(Object object, int min, int max) {
        String userStringInput = (String) object;
        return (min <= userStringInput.length() && userStringInput.length() <= max);
    }
}
