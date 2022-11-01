package onboarding;

public class Problem3 {

    static byte[] saveByDigit = new byte[5];
    public static int solution(int number) {
        if (numberOutOfRangeException(number)) {
            return number;
        }
        return countClapCase(number);
    }
}