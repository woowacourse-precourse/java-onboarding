package onboarding;

/**
 * @Problem: 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem3 {
    public static int solution(int number) {
        return calcClap(number);
    }

    private static int calcClap(int number) {
        if(number < 10) {
            return number / 3; // 1의 자리인 경우, 3으로 나눈 몫을 return한다.
        }

        int answer = 0;
        answer += calcClapZeroToHighDigit(number); // 1 ~ 현재 자리수 - 1 까지의 박수소리
        answer += calcLowerClap(number);  // 각 자릿수가 3의 배수일 때, 해당 자릿수 이하의 수 + 1만큼을 더해주어야, 실제 박수 소리를 구할 수 있다.
        answer += calcClap(getLowerNumber(number));
        return answer;
    }

    private static int calcClapZeroToHighDigit(int number) {
        int tempMaxDigit = getMaxDigit(number);
        int length = getLength(number);
        int multipleOfTen = getMultipleOfTen(number);

        int answer = tempMaxDigit * 3 * (multipleOfTen / 10) * (length - 1);
        if (tempMaxDigit > 3) {
            answer += ((tempMaxDigit - 1) / 3) * multipleOfTen;
        }
        return answer;
    }

    private static int calcLowerClap(int number) {
        if(getMaxDigit(number) % 3 == 0) {  // 현재 자릿수의 값이 3의 배수라면, 하위값 + 1만큼 박수 수가 추가된다.
            return getLowerNumber(number) + 1;
        }
        return 0;
    }

    private static int getMaxDigit(int number) {
        return number / getMultipleOfTen(number);
    }

    private static int getLowerNumber(int number) {
        return number - (getMaxDigit(number) * getMultipleOfTen(number));
    }

    private static int getLength(int number) {
        return (int)(Math.log10(number) + 1);
    }

    private static int getMultipleOfTen(int number) {
        return (int) Math.pow(10, (getLength(number) - 1));
    }
}
