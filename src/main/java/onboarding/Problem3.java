package onboarding;

public class Problem3 {
    // 기능#2 1부터 주어진 숫자까지 기능#1을 반복하여 총합을 구하는 기능
    public static int solution(int number) {
        int allClapCount = 0;

        for(int i = 1; i <= number; ++i) {
            allClapCount += countClapByNumber(i);
        }

        return allClapCount;
    }

    // 기능#1 어느 숫자를 주면 그 숫자에 3/6/9가 몇 번 들어있는지 세어주는 기능
    static int countClapByNumber(int num) {
        int count = 0;
        int digit;
        while(num != 0) {
            digit = num % 10;
            System.out.println(digit);
            if(digit == 3 || digit == 6 || digit == 9) {
                ++count;
            }
            num /= 10;
        }
        return count;
    }

}
