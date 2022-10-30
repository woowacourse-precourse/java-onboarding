package onboarding.problem3;

import static onboarding.problem3.InputNumberValidator.validateNumber;

public class ThreeSixNineGame {

    public int do369(int number) {
        validateNumber(number);
        int result = 0;

        // 이걸 스트림으로 바꿀 수는 있다. 하지만 고민이다. for loop가 빠를 경우가 있기 때문이다.
        for (int i = 1; i <= number; i++) {
            String strNum = String.valueOf(i);

            if (contains369(strNum)) {
                result += count369(strNum);
            }
        }

        return result;
    }

    private boolean contains369(String number) {
        return number.contains("3") || number.contains("6") || number.contains("9");
    }

    private int count369(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';

            if (num == 3 || num == 6 || num == 9) {
                count++;
            }
        }

        return count;
    }

}
