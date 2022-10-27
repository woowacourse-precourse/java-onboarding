package onboarding;

public class Problem3 {
    static final int EXCEPTION = -1;
    static final int NUM_LOWERBOUND = 1;
    static final int NUM_UPPERBOUND = 10000;
    public static int solution(int number) {
        int result = getSolution(number);
        return result;
    }
    public static int getSolution(int number) {
        if (validationCheck(number)) {
            int result = count369All(number);
            return result;
        }
        return EXCEPTION;
    }
    public static boolean validationCheck(int number) {
        if (number < NUM_LOWERBOUND || number > NUM_UPPERBOUND) {
            return false;
        }
        return true;
    }
    public static int count369(int number) {
        String stringNumber = Integer.toString(number);
        int result = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            char charNum = stringNumber.charAt(i);
            if ((charNum - '0') % 3 == 0 && charNum != '0') {
                result += 1;
            }
        }
        return result;
    }
    public static int count369All(int number) {
        int result = 0;
        for (int i = 1; i < number + 1; i++) {
            result += count369(i);
        }
        return result;
    }
}


/*
1. 입력 조건에 맞지 않는 경우 예외처리 기능
- 1 이상 10000 이하의 자연수인지 체크
2. 주어진 숫자가 3, 6, 9 키워드를 몇개 포함하고 있는지 체크하는 기능
3. 총 3, 6, 9 키워드가 몇개인지 계산하는 기능
*/