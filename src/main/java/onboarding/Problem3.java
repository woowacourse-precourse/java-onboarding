package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = calcNumberOfClap(number);
        return answer;
    }

    // 주어진 한 자리수의 값이 3, 6, 9인지 확인하는 함수
    public static int checkSingleDigitNumber(int number) {
        int value = 0;
        if (number == 3 || number == 6 || number == 9) value = 1;
        return value;
    }

    // 주어진 여러 자리수의 값에 3, 6, 9가 몇 개 들어있는지 확인하는 함수
    public static int calcMultiDigitNumbers(int number) {
        int numberOftarget = 0;
        while (number > 0) {
            numberOftarget += checkSingleDigitNumber(number % 10);
            number /= 10;
        }
        return numberOftarget;
    }

    // 1부터 number까지의 3, 6, 9 개수를 구하는 함수
    public static int calcNumberOfClap(int number) {
        int resultNumber = 0;
        for (int i = 1; i <= number; i++) {
            resultNumber += calcMultiDigitNumbers(i);
        }
        return resultNumber;
    }
}
