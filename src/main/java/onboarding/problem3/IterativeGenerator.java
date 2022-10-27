package onboarding.problem3;

public class IterativeGenerator {

    public int typeConversion(int number) {

        CheckNumbers checkNumbers = new CheckNumbers();

        int compare = 0;

        for (int numberIndex = 1; numberIndex <= number; numberIndex++) {
            String strNumber = String.valueOf(numberIndex);
            compare = checkNumbers.compare(strNumber);
        }

        return compare;
    }
}