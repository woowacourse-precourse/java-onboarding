package onboarding.problem1;

import java.util.List;

public class Pages {
    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;

    private int leftNumber;
    private int rightNumber;

    private void validate(List<Integer> indexes) throws IllegalArgumentException {
        hasNullValue(indexes);
        int leftNo = indexes.get(LEFT_INDEX);
        int rightNo = indexes.get(RIGHT_INDEX);

        isContinuousNumbers(leftNo, rightNo);
        isInProperRange(leftNo, rightNo);
    }

    private void hasNullValue(List<Integer> indexes) {
        for (Integer idx : indexes) {
            if(idx == null){
                throw new IllegalArgumentException();
            }
        }
    }

    private void isContinuousNumbers(int leftNumber, int rightNumber) {
        if (rightNumber - leftNumber != 1)
            throw new IllegalArgumentException();
    }

    private void isInProperRange(int leftNumber, int rightNumber) {
        if (1 < leftNumber && leftNumber < rightNumber && rightNumber < 400) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public Pages(List<Integer> indexes) {
        validate(indexes);
        this.leftNumber = indexes.get(LEFT_INDEX);
        this.rightNumber = indexes.get(RIGHT_INDEX);
    }

    private int calculateEachDigitBySum(int pageNumber) {
        int result=0;
        int target=pageNumber;
        while(target>0){
            result += target%10;
            target/=10;
        }
        return result;
    }
}