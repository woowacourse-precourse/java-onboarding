package onboarding.problem3;

public class Game369 {

    InputNumberValidator inputNumberValidator = new InputNumberValidator();
    public int getClapCount(int number) {
        inputNumberValidator.validate(number);

        int clapCount = 0;
        for (int i = 1; i <=number; i++) {
            clapCount += getInner369count(i);
        }

        return clapCount;
    }

    private int getInner369count(int number) {
        int innerCount = 0;
        while (number > 0) {
            if(is369Number(number)) {
                innerCount++;
            }
            number /= 10;
        }

        return innerCount;
    }

    private boolean is369Number(int number) {
        return number % 10 == 3 ||
                number % 10 == 6 ||
                number % 10 == 9;
    }
}
