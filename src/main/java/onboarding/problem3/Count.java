package onboarding.problem3;

public class Count {
    public static int count369(SplittedNumber number) {
        int result = 0;
        int forIter = number.getAsInt();
        while(forIter != 0) {
            SplittedNumber iterNumber = new SplittedNumber(forIter);
            result += iterNumber.getCountOfThree();
            forIter--;
        }
        return result;
    }
}
