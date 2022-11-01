package onboarding.problem3;

public class IterativeGenerator {

    public int typeConversion(int number) {

        int compare = 0;

        CheckNumbers checkNumbers = new CheckNumbers();

        for (int numberIndex = 1; numberIndex <= number; numberIndex++) {

            String strNumber = String.valueOf(numberIndex);
            compare += checkNumbers.compare(strNumber);
        }

        return compare;
    }
}